package com.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private BigDecimal amount;
    private BigDecimal interestRate;
    private String loanType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

}