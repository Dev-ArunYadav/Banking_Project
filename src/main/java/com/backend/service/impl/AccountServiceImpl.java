package com.backend.service.impl;

import com.backend.dto.request.AccountCreationRequestDTO;
import com.backend.dto.response.AccountCreationResponseDTO;
import com.backend.entity.Account;
import com.backend.entity.EnumAccountStatus;
import com.backend.entity.EnunRole;
import com.backend.entity.User;
import com.backend.exception.AccountCreationException;
import com.backend.mapper.AccountMapper;
import com.backend.model.AccountCredentials;
import com.backend.repository.AccountRepository;
import com.backend.repository.UserRepository;
import com.backend.service.interfaces.AccountService;
import com.backend.util.Constants;
import com.backend.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final EmailServiceImpl emailService;
    private final IdGenerator idGenerator;
    private final AccountMapper accountMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountCreationResponseDTO createAccount(AccountCreationRequestDTO request) {
        log.info("Starting account creation process for {}", request.getEmail());

        validateAccountDetails(request);
        AccountCredentials credentials = idGenerator.generateCredentials();

        Account account = accountMapper.toEntity(request);
        enrichAccountDetails(account, credentials);
        Account savedAccount = accountRepository.save(account);

        try {
            User user = createUserForAccount(credentials);
            savedAccount.setUser(user);
            savedAccount = accountRepository.save(savedAccount);

            emailService.sendWelcomeEmail(savedAccount, credentials);
            log.info("Account created successfully for {}", request.getEmail());

            return accountMapper.toResponseDTO(savedAccount, credentials);
        } catch (Exception e) {
            log.error("Failed to create user for account: {}", e.getMessage());
            accountRepository.delete(savedAccount);
            throw new AccountCreationException("Failed to complete account creation", e);
        }
    }

    @Override
    public void validateAccountDetails(AccountCreationRequestDTO request) {

    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findByCustomerId(String customerId) {
        return Optional.empty();
    }

    private User createUserForAccount(AccountCredentials credentials) {
        User user = new User();
        user.setCustomerId(Long.parseLong(credentials.getCustomerId()));
        user.setPassword(passwordEncoder.encode(credentials.getTemporaryPassword()));
        user.setRole(EnunRole.CUSTOMER);
        return userRepository.save(user);
    }

    private void enrichAccountDetails(Account account, AccountCredentials credentials) {
        account.setAccountNumber(credentials.getAccountNumber());
        account.setBankName(Constants.BANK_NAME);
        account.setBranchName(Constants.MAIN_BRANCH);
        account.setIfscCode(Constants.IFSC_CODE);
        account.setStatus(EnumAccountStatus.PENDING);
        account.setRegistrationDate(LocalDateTime.now());
        account.setBalance(0.0);
    }
}
