package com.backend.service.impl;

import com.backend.enums.EnunRole;
import com.backend.model.Account;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import com.backend.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailServiceImpl emailService;

    public User createUser(Account account) {
        User user = new User();

        // Generate Customer ID (CUST + timestamp + random 4 digits)
        Long customerId = generateCustomerId();

        // Generate password (8 characters: letters + numbers)
        String plainPassword = generateRandomPassword();

        user.setCustomerId(customerId);
        user.setPassword(passwordEncoder.encode(plainPassword));
        user.setRole(EnunRole.CUSTOMER);
        user.setLastLogin(null);

        User savedUser = userRepository.save(user);

        // Send credentials via email
        emailService.sendCredentialsEmail(account.getEmail(), customerId, plainPassword);

        return savedUser;
    }

    private Long generateCustomerId() {
        // Generate a unique 10-digit customer ID
        long timestamp = System.currentTimeMillis() % 1000000; // last 6 digits of timestamp
        int random = new Random().nextInt(9000) + 1000; // 4 digit random number
        return Long.parseLong(String.format("%06d%04d", timestamp, random));
    }

    private String generateRandomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}