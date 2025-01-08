package com.backend.service.interfaces;

import com.backend.entity.Account;
import com.backend.model.AccountCredentials;

public interface EmailService {
    void sendWelcomeEmail(Account account, AccountCredentials credentials);
    void sendOtp(String email, String otp);
    void sendPasswordResetEmail(String email, String resetToken);
}
