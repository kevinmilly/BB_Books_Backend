package com.accounting.bookkeeping.service.implementation;

import com.accounting.bookkeeping.domain.Transaction;
import com.accounting.bookkeeping.enumeration.Category;
import com.accounting.bookkeeping.repo.TransactionRepo;
import com.accounting.bookkeeping.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.*;
import static org.springframework.data.domain.PageRequest.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepo transactionRepo;

    @Override
    public Transaction create(Transaction transaction) {
        log.info("Saving {} - {} {}", transaction.getTransactionDate(),transaction.getDescription(), transaction.getTransactionAmount());
        return transactionRepo.save(transaction);
    }

    @Override
    public Collection<Transaction> list(int limit) {
        log.info("Fetching all transactions");
        return transactionRepo.findAll(of(0, limit)).toList();
    }

    @Override
    public Collection<Transaction> listByDate(String date) {
        log.info("Fetching Transaction by date: {}", date);
        return transactionRepo.findByTransactionDate(date);
    }

    @Override
    public Collection<Transaction> listByCategory(Category category) {
        log.info("Fetching Transaction by category: {}", category);
        return transactionRepo.findByCategory(category);
    }

    @Override
    public Transaction get(Long id) {
        log.info("Fetching Transaction by id: {}", id);
        return transactionRepo.getById(id);
    }

    @Override
    public Transaction update(Transaction transaction) {
        log.info("Updating {} - {} {}", transaction.getTransactionDate(),transaction.getDescription(), transaction.getTransactionAmount());
        return transactionRepo.save(transaction);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting transaction by id");
        transactionRepo.deleteById(id);
        return TRUE;
    }
}
