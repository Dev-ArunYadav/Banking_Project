package com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "bank_employee_id")
    private Long bankEmployeeId;
    @Column(name = "system_admin_id")
    private Long systemAdminId;
    private String password;
    private EnunRole role; // CUSTOMER, BANK_EMPLOYEE, SYSTEM_ADMIN

    // Getters and Setters
}