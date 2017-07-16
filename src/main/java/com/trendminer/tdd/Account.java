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
    private int money;
    private List<BankTransaction> transactions = new ArrayList<BankTransaction>();

    public Account(String name, String userId, String userAddress) {
        this.name = name;
        this.userID = userId;
        this.address = userAddress;
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
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        transactions.add(new BankTransaction(money));
        this.money += money;
    }

    public List<BankTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<BankTransaction> transactions) {
        this.transactions = transactions;
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
