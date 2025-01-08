package com.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Account account;
    private String cardNumber;
    private String cardType;
    private LocalDate expiryDate;
    private String pin;
    private boolean isBlocked;

}
