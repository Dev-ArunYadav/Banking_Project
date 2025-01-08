package com.backend.controller;

import com.backend.dto.request.AccountCreationRequest;
import com.backend.enums.EnumAccountType;
import com.backend.model.Account;
import com.backend.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Account> createAccount(
            @RequestParam String accountHolder,
            @RequestParam String gender,
            @RequestParam String dateOfBirth,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String address,
            @RequestParam String city,
            @RequestParam String state,
            @RequestParam String country,
            @RequestParam String pincode,
            @RequestParam String panCardNumber,
            @RequestParam String aadhaarNumber,
            @RequestParam(required = false) MultipartFile passportPhoto,
            @RequestParam(required = false) MultipartFile panCardImage,
            @RequestParam(required = false) MultipartFile aadhaarCardImage,
            @RequestParam(required = false) MultipartFile electricityBillImage,
            @RequestParam EnumAccountType accountType
    ) throws IOException {
        AccountCreationRequest request = new AccountCreationRequest();
        request.setAccountHolder(accountHolder);
        request.setGender(gender);
        request.setDateOfBirth(dateOfBirth);
        request.setEmail(email);
        request.setPhoneNumber(phoneNumber);
        request.setAddress(address);
        request.setCity(city);
        request.setState(state);
        request.setCountry(country);
        request.setPincode(pincode);
        request.setPanCardNumber(panCardNumber);
        request.setAadhaarNumber(aadhaarNumber);
        request.setPassportPhoto(passportPhoto);
        request.setPanCardImage(panCardImage);
        request.setAadhaarCardImage(aadhaarCardImage);
        request.setElectricityBillImage(electricityBillImage);
        request.setAccountType(accountType);

        Account account = accountService.createAccount(request);
        return ResponseEntity.ok(account);
    }
}