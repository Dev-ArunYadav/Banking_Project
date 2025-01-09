package com.backend.repository;

import com.backend.enums.EnumAccountStatus;
import com.backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUser_Id(Long userId);
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByStatus(EnumAccountStatus status);
}

