package com.accounting.bookkeeping;

import com.accounting.bookkeeping.domain.Transaction;
import com.accounting.bookkeeping.enumeration.Category;
import com.accounting.bookkeeping.repo.TransactionRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookkeepingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeepingApplication.class, args);
    }

    @Bean
    CommandLineRunner run(TransactionRepo transactionRepo) throws Exception {

        return args -> {
            transactionRepo.save(new Transaction(null, 2000, Category.W2_INCOME, "1/15/2022", 4, "Engineering Job"));
            transactionRepo.save(new Transaction(null, 500, Category.SELF_EMPLOYMENT_INCOME, "1/25/2022", 4, "Freelance"));
            transactionRepo.save(new Transaction(null, -100, Category.GROCERIES, "1/17/2022", 2, "Went to Publix"));
        };
    }

}
