package com.trendminer.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by haduart on 14/07/2017.
 */
public class VirtualCurrencyTest {
    final int HUNDRED_EUROS = 100;

    Bank bank = new Bank();
    String userID;
    String secondUserID;
    String name;
    String userAddress;

    Account firstAccount;
    Account secondAccount;

    @Before
    public void setUp() throws Exception {
        userID = "ES" + generateRandomValue();
        name = "Eduard" + generateRandomValue();
        userAddress = "Plantenstraat " + generateRandomValue() + " , 3500, Belgium";
    }

    @Test
    public void createAccountInBank() {
        Account account = whenCreatingAnAccount();

        thenAccountIsCreated(account);
    }

    @Test
    public void insertMoneyInMyAccount() {
        whenCreatingAnAccount();

        whenInsertingMoney(HUNDRED_EUROS);

        thenCheckTotalMoney(HUNDRED_EUROS);
    }

    @Test
    public void insertMultipleTransactionsInMyAccount() {
        whenCreatingAnAccount();

        whenInsertingMoney(HUNDRED_EUROS);
        whenInsertingMoney(2 * HUNDRED_EUROS);

        thenCheckTotalMoney(3 * HUNDRED_EUROS);
    }

    @Test
    public void insertingMoneyFromMultipleAccounts() {
        whenCreatingAnAccount();
        whenCreatingASecondAccount();

        whenInsertingMoney(HUNDRED_EUROS);
        whenInsertingMoneySecondAccount(HUNDRED_EUROS);

        thenCheckTotalMoney(HUNDRED_EUROS);
        thenCheckTotalMoney(secondUserID, HUNDRED_EUROS);
    }

    @Test(expected = AccountNotFoundException.class)
    public void notPossibleToInsertMoneyToUnknowAccount() {
        final String unknowUserID = "ES6666";
        bank.insertMoney(HUNDRED_EUROS, unknowUserID);
    }

    @Test
    public void checkTransactionsFromUser() {
        whenCreatingAnAccount();

        whenInsertingMoney(HUNDRED_EUROS);
        whenInsertingMoney(HUNDRED_EUROS);

        thenCheckTransactionsFirstAccount();
    }

    @Test
    public void checkTransactionsFromMultipleUsers() {
        whenCreatingAnAccount();
        whenCreatingASecondAccount();

        whenInsertingMoney(HUNDRED_EUROS);
        whenInsertingMoney(HUNDRED_EUROS);
        whenInsertingMoneySecondAccount(HUNDRED_EUROS);

        thenCheckTransactionsFirstAccount();

        thenCheckTransactionsSecondAccount();
    }

    private void thenCheckTotalMoney(String userID, int ammount) {
        assertEquals(bank.checkTotalMoney(userID), ammount);
    }

    private void thenCheckTotalMoney(int ammount) {
        assertEquals(bank.checkTotalMoney(userID), ammount);
    }

    private void thenCheckTransactionsSecondAccount() {
        List<BankTransaction> secondUserTransactions = bank.getTransactions(secondUserID);
        assertEquals(1, secondUserTransactions.size());
        assertEquals(HUNDRED_EUROS, secondUserTransactions.get(0).getAmount());
    }

    private void thenCheckTransactionsFirstAccount() {
        List<BankTransaction> transactions = bank.getTransactions(userID);

        assertEquals(2, transactions.size());
        assertEquals(HUNDRED_EUROS, transactions.get(0).getAmount());
        assertEquals(HUNDRED_EUROS, transactions.get(1).getAmount());
    }

    private Account whenCreatingASecondAccount() {
        secondAccount = bank.createAccount("Roberto", "ES1111", "San Cagat 5, Barcelona, Spain");
        secondUserID = secondAccount.getUserID();
        return secondAccount;
    }

    private void thenAccountIsCreated(Account account) {
        assertEquals(name, account.getName());
        assertEquals(userID, account.getUserID());
        assertEquals(userAddress, account.getAddress());
    }

    private void whenInsertingMoneySecondAccount(int amount) {
        bank.insertMoney(amount, secondUserID);
    }

    private void whenInsertingMoney(int amount) {
        bank.insertMoney(amount, userID);
    }

    private Account whenCreatingAnAccount() {
        firstAccount =  bank.createAccount(name, userID, userAddress);
        return firstAccount;
    }

    private int generateRandomValue() {
        return (int) (Math.random() * 100);
    }

}
