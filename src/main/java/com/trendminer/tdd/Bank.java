package com.trendminer.tdd;

import java.util.HashMap;
import java.util.List;

/**
 * Created by haduart on 14/07/2017.
 */
public class Bank {
    HashMap<String, Account> accounts = new HashMap<String, Account>();

    public Account createAccount(String name, String userId, String userAddress) {
        final Account account = new Account(name, userId, userAddress);
        accounts.put(userId, account);
        return account;
    }

    public void insertMoney(int money, String userID) {
        Account account = accounts.get(userID);
        if (account == null)
            throw new AccountNotFoundException();
        account.addMoney(money);
    }

    public void substractMoney(int money, String userID) {
        Account account = accounts.get(userID);
        if (account == null)
            throw new AccountNotFoundException();
        account.substractMoney(money);
    }

    public int checkTotalMoney(String userID) {
        Account account = accounts.get(userID);
        return account.getMoney();
    }

    public List<BankTransaction> getTransactions(String userID) {
        Account account = accounts.get(userID);
        return account.getTransactions();
    }
}
