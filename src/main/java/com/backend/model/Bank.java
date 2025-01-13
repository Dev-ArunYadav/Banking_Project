package com.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bank")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "branch", nullable = false)
    private String branch;

    @Column(name = "ifsc_code", nullable = false, unique = true)
    private String ifscCode;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false, unique = true)
    private List<Account> accounts;
}
