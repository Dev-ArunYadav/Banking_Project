package com.backend.service.impl;

import com.backend.dto.request.AccountCreationRequest;
import com.backend.enums.EnumAccountStatus;
import com.backend.model.Account;
import com.backend.model.User;
import com.backend.repository.AccountRepository;
import com.backend.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    @Transactional
    public Account createAccount(AccountCreationRequest request) throws IOException {
        Account account = new Account();

        // Set personal details
        account.setAccountHolder(request.getAccountHolder());
        account.setGender(request.getGender());
        account.setDateOfBirth(request.getDateOfBirth());
        account.setEmail(request.getEmail());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setAddress(request.getAddress());
        account.setCity(request.getCity());
        account.setState(request.getState());
        account.setCountry(request.getCountry());
        account.setPincode(request.getPincode());

        // Set document details
        account.setPanCardNumber(request.getPanCardNumber());
        account.setAadhaarNumber(request.getAadhaarNumber());

        // Handle document uploads
        if (request.getPassportPhoto() != null) {
            account.setPassportPhoto(request.getPassportPhoto().getBytes());
        }
        if (request.getPanCardImage() != null) {
            account.setPanCardImage(request.getPanCardImage().getBytes());
        }
        if (request.getAadhaarCardImage() != null) {
            account.setAadhaarCardImage(request.getAadhaarCardImage().getBytes());
        }
        if (request.getElectricityBillImage() != null) {
            account.setElectricityBillImage(request.getElectricityBillImage().getBytes());
        }

        // Set bank details
        account.setBankName("Lakshmi Cheatfund Bank");
        account.setAccountNumber(generateAccountNumber());
        account.setBranchName("Main Branch");
        account.setIfscCode("LKSMI0001");
        account.setAccountType(request.getAccountType());
        account.setBalance(0.0);
        account.setStatus(EnumAccountStatus.ACTIVE);

        // Set bank contact details
        account.setBankAddress("Your Bank Address");
        account.setBankContactNumber("1800-XXX-XXXX");
        account.setBankEmail("support@yourbank.com");

        // Set timestamps
        account.setRegistrationDate(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());

        // Create and set user
        User user = userService.createUser(account);
        account.setUser(user);

        return accountRepository.save(account);
    }

    private String generateAccountNumber() {
        // Generate a 12-digit account number
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }
}