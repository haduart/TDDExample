package com.trendminer.tdd;

/**
 * Created by haduart on 14/07/2017.
 */
public interface BankTransaction {
    int getAmount();

    int processTransaction(int previousAmount);

}
