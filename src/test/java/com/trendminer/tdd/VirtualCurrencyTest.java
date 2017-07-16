package com.trendminer.tdd;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by haduart on 14/07/2017.
 */
public class VirtualCurrencyTest {

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
    }

//    @Test
    public void insertMoneyInMyAccount() {
    }

//    @Test
    public void insertMultipleTransactionsInMyAccount() {
    }

//    @Test
    public void insertingMoneyFromMultipleAccounts() {
    }

//    @Test(expected = AccountNotFoundException.class)
    public void notPossibleToInsertMoneyToUnknowAccount() {
    }

//    @Test
    public void checkTransactionsFromUser() {
    }

//    @Test
    public void checkTransactionsFromMultipleUsers() {
    }

    private int generateRandomValue() {
        return (int) (Math.random() * 100);
    }

}
