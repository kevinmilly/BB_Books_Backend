package com.accounting.bookkeeping.enumeration;

public enum Category {
    W2_INCOME("W2_INCOME"),
    SELF_EMPLOYMENT_INCOME("SELF_EMPLOYMENT_INCOME"),
    INVESTMENT_INCOME("INVESTMENT_INCOME"),
    FUN("FUN"),
    GROCERIES("GROCERIES"),
    EATING_OUT("EATING_OUT"),
    FAMILY("FAMILY"),
    CAR("CAR"),
    EDUCATION("EDUCATION");

    private final String transactionType;

    Category(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

}
