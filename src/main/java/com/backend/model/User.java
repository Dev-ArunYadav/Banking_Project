package com.backend.model;

import com.backend.enums.EnunRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "user")
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

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private EnunRole role;

    private LocalDateTime lastLogin;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setBankEmployeeId(Long bankEmployeeId) {
        this.bankEmployeeId = bankEmployeeId;
    }

    public void setSystemAdminId(Long systemAdminId) {
        this.systemAdminId = systemAdminId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(EnunRole role) {
        this.role = role;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
