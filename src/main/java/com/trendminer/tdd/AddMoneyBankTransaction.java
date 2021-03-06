package com.trendminer.tdd;

import java.util.Date;

/**
 * Created by haduart on 14/07/2017.
 */
public class AddMoneyBankTransaction implements BankTransaction {
    private int amount;

    private Date ts;

    public AddMoneyBankTransaction(int amount) {
        this.ts = new Date();
        this.amount = amount;
    }

    @Override
    public Date getTs() {
        return ts;
    }

    public int getAmount() {
        return amount;
    }

    public int processTransaction(int previousAmount) {
        return previousAmount + amount;
    }
}
