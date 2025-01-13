package com.backend.model;

import com.backend.enums.EnumRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor()
@NoArgsConstructor()
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id",nullable = false, unique = true)
    private Long customerId;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private EnumRole role = EnumRole.CUSTOMER;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;
}
