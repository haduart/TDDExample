package com.trendminer.tdd;

import java.util.Date;

/**
 * Created by haduart on 14/07/2017.
 */
public interface BankTransaction {
    Date getTs();

    int getAmount();

    int processTransaction(int previousAmount);

}
