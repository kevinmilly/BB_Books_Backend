package com.accounting.bookkeeping.resource;

import com.accounting.bookkeeping.domain.Response;
import com.accounting.bookkeeping.domain.Transaction;
import com.accounting.bookkeeping.service.implementation.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionResource {
    private final TransactionServiceImpl transactionService;

    @GetMapping("/list")
    public ResponseEntity<Response> getTransactions(@PathVariable("listQuantity") int listQuantity) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("transactions", transactionService.list(listQuantity)))
                        .message("Transactions retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveTransaction(@RequestBody @Valid Transaction transaction) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("transaction", transactionService.create(transaction)))
                        .message("Transaction created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getTransactionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("transaction", transactionService.get(id)))
                        .message("Transaction retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteTransaction(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", transactionService.delete(id)))
                        .message("Transaction deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateTransaction(@RequestBody @Valid Transaction transaction) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("transaction", transactionService.create(transaction)))
                        .message("Transaction updated")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
