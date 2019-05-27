package com.company;

import java.util.Comparator;

public class ComparatorTrans implements Comparator<Transaction> {
    @Override
    public int compare(Transaction o1, Transaction o2) {
        int flag = o1.delay - o2.delay;
        return flag;
    }
}
