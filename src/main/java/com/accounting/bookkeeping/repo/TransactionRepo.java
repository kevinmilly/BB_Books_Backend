package com.accounting.bookkeeping.repo;

import com.accounting.bookkeeping.domain.Transaction;
import com.accounting.bookkeeping.enumeration.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTransactionDate(String transactionDate);
    List<Transaction> findByCategory(Category category);
}
