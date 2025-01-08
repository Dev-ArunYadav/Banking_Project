package com.backend.util;

import com.backend.model.AccountCredentials;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class IdGenerator {
    public AccountCredentials generateCredentials() {
        return AccountCredentials.builder()
                .customerId(generateCustomerId())
                .accountNumber(generateAccountNumber())
                .temporaryPassword(generateTemporaryPassword())
                .build();
    }

    private String generateTemporaryPassword() {
        return String.format("%06d", ThreadLocalRandom.current().nextInt(100000, 999999));
    }

    private String generateAccountNumber() {
        return String.format("%06d", ThreadLocalRandom.current().nextInt(100000, 999999));
    }


    private String generateCustomerId() {
        return String.format("CUS%d%06d",
                LocalDateTime.now().getYear(),
                ThreadLocalRandom.current().nextInt(100000, 999999));
    }
}
