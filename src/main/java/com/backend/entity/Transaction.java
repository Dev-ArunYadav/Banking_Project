package com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id")
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "transaction_type")
    private EnumTransactionType transactionType;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "transaction_status")
    private EnumTransactionStatus transactionStatus;

    @Column(name = "description")
    private String description;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "recipient_account_id")
    private String recipientAccountId;

    @Column(name = "transaction_date")
    private String transactionDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
