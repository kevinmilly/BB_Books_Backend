package com.accounting.bookkeeping.service;

import com.accounting.bookkeeping.domain.Transaction;
import com.accounting.bookkeeping.enumeration.Category;

import java.util.Collection;

public interface TransactionService {

    Transaction create(Transaction transaction);
    Collection<Transaction> list(int limit);
    Collection<Transaction> listByDate(String date);
    Collection<Transaction> listByCategory(Category category);
    Transaction get(Long id);
    Transaction update(Transaction transaction);
    Boolean delete(Long id);
}
