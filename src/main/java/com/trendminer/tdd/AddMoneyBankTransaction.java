package com.trendminer.tdd;

/**
 * Created by haduart on 14/07/2017.
 */
public class AddMoneyBankTransaction implements BankTransaction {
    private int amount;

    public AddMoneyBankTransaction(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int processTransaction(int previousAmount) {
        return previousAmount + amount;
    }
}
