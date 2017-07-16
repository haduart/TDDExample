package com.trendminer.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by haduart on 14/07/2017.
 */
public class VirtualCurrencyTest {

    Bank bank = new Bank();
    String userID;
    String name;
    String userAddress;

    @Before
    public void setUp() throws Exception {
        userID = "ES" + generateRandomValue();
        name = "Eduard" + generateRandomValue();
        userAddress = "Plantenstraat " + generateRandomValue() + " , 3500, Belgium";
    }

    @Test
    public void createAccountInBank() {
        Account eduAccount = bank.createAccount(name, userID, userAddress);

        assertEquals(name, eduAccount.getName());
        assertEquals(userID, eduAccount.getUserID());
        assertEquals(userAddress, eduAccount.getAddress());
    }

    @Test
    public void insertMoneyInMyAccount() {
        Account eduAccount = bank.createAccount(name, userID, userAddress);

        bank.insertMoney(100, eduAccount.getUserID());

        assertEquals(bank.checkTotalMoney(eduAccount.getUserID()), 100);
    }

    @Test
    public void insertMultipleTransactionsInMyAccount() {
        Account eduAccount = bank.createAccount(name, userID, userAddress);

        final String userID = eduAccount.getUserID();
        bank.insertMoney(100, userID);
        bank.insertMoney(200, userID);

        assertEquals(bank.checkTotalMoney(userID), 300);
    }

    @Test
    public void insertingMoneyFromMultipleAccounts() {
        Account eduAccount = bank.createAccount(name, userID, userAddress);
        Account robertoAccount = bank.createAccount("Roberto", "ES1111", "San Cagat 5, Barcelona, Spain");

        bank.insertMoney(100, eduAccount.getUserID());
        bank.insertMoney(100, robertoAccount.getUserID());

        assertEquals(bank.checkTotalMoney(eduAccount.getUserID()), 100);
        assertEquals(bank.checkTotalMoney(robertoAccount.getUserID()), 100);
    }

    @Test(expected = AccountNotFoundException.class)
    public void notPossibleToInsertMoneyToUnknowAccount() {
        final String unknowUserID = "ES6666";
        bank.insertMoney(100, unknowUserID);
    }

    @Test
    public void checkTransactionsFromUser() {
        Account eduAccount = bank.createAccount(name, userID, userAddress);

        final String userID = eduAccount.getUserID();
        bank.insertMoney(100, userID);
        bank.insertMoney(200, userID);

        List<BankTransaction> transactions = bank.getTransactions(userID);

        assertEquals(2, transactions.size());
        assertEquals(100, transactions.get(0).getAmmount());
        assertEquals(200, transactions.get(1).getAmmount());
    }

    @Test
    public void checkTransactionsFromMultipleUsers() {
        Account eduAccount = bank.createAccount(name, userID, userAddress);
        Account robertoAccount = bank.createAccount("Roberto", "ES1111", "San Cagat 5, Barcelona, Spain");

        bank.insertMoney(100, eduAccount.getUserID());
        bank.insertMoney(200, eduAccount.getUserID());
        bank.insertMoney(50, robertoAccount.getUserID());

        List<BankTransaction> eduTransactions = bank.getTransactions(userID);

        assertEquals(2, eduTransactions.size());
        assertEquals(100, eduTransactions.get(0).getAmmount());
        assertEquals(200, eduTransactions.get(1).getAmmount());

        List<BankTransaction> robertoTransactions = bank.getTransactions(robertoAccount.getUserID());
        assertEquals(1, robertoTransactions.size());
        assertEquals(50, robertoTransactions.get(0).getAmmount());
    }


    private int generateRandomValue() {
        return (int) (Math.random() * 100);
    }

}
