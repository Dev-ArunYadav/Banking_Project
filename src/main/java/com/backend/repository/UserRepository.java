package com.backend.repository;

import com.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBySystemAdminId(Long systemAdminId);
    Optional<User> findByCustomerId(Long customerId);
    Optional<User> findByBankEmployeeId(Long bankEmployeeId);
}
