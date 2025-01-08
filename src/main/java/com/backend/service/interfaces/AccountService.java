package com.backend.service.interfaces;

import com.backend.dto.request.AccountCreationRequestDTO;
import com.backend.dto.response.AccountCreationResponseDTO;
import com.backend.entity.Account;

import java.util.Optional;

public interface AccountService {
    AccountCreationResponseDTO createAccount(AccountCreationRequestDTO request);
    void validateAccountDetails(AccountCreationRequestDTO request);
    Optional<Account> findByAccountNumber(String accountNumber);
    Optional<Account> findByCustomerId(String customerId);
}
