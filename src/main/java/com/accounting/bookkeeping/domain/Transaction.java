package com.accounting.bookkeeping.domain;

import com.accounting.bookkeeping.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Must put a transaction amount")
    private float transactionAmount;
    @NotNull(message = "Must put a category")
    private Category category;
    @NotEmpty(message = "Must put a transactionDate")
    private String transactionDate;
    private int monthlyRecurrence;
    private String description;



}
