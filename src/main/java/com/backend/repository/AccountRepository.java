package com.backend.repository;

import com.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByPanCardNumber(String panCardNumber);
    boolean existsByAadhaarNumber(String aadhaarNumber);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<Account> findByAccountNumber(String accountNumber);
    Optional<Account> findByUser_CustomerId(Long customerId);
}

