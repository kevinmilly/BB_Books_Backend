package com.accounting.bookkeeping.enumeration;

public enum TransactionType {

    INCOME("INCOME"),
    EXPENSE("EXPENSE");

    private final String transactionType;

    TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return this.transactionType;
    }
}
