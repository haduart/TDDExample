package com.trendminer.tdd;

import java.util.Date;

/**
 * Created by haduart on 14/07/2017.
 */
public class InitialMoneyBankTransaction implements BankTransaction {
    private Date ts;

    public InitialMoneyBankTransaction() {
        this.ts = new Date();
    }

    @Override
    public Date getTs() {
        return ts;
    }

    public int getAmount() {
        return 0;
    }

    public int processTransaction(int previousAmount) {
        return 0;
    }
}
