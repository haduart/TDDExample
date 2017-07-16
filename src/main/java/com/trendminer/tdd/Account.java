package com.trendminer.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haduart on 14/07/2017.
 */
public class Account {
    private String name;
    private String userID;
    private String address;
    private List<BankTransaction> transactions = new ArrayList<BankTransaction>();

    public Account(String name, String userId, String userAddress) {
        this.name = name;
        this.userID = userId;
        this.address = userAddress;
        transactions.add(new InitialMoneyBankTransaction());
    }

    public String getName() {
        return name;
    }

    public String getUserID() {
        return userID;
    }

    public String getAddress() {
        return address;
    }

    public int getMoney() {
        final int[] money = {0};
        transactions.stream().forEach(t -> money[0] = t.processTransaction(money[0]));
        return money[0];
    }

    public void addMoney(int money) {
        transactions.add(new AddMoneyBankTransaction(money));
    }

    public void substractMoney(int money) {
        transactions.add(new SubstractMoneyBankTransaction(money));
    }

    public List<BankTransaction> getTransactions() {
        return transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return userID.equals(account.userID);

    }

    @Override
    public int hashCode() {
        return userID.hashCode();
    }
}
