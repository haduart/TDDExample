package com.trendminer.tdd;

/**
 * Created by haduart on 14/07/2017.
 */
public class BankTransaction {
    private int ammount;

    public BankTransaction(int ammount) {
        this.ammount = ammount;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
}
