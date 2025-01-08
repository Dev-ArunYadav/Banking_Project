package com.backend.service.impl;

import com.backend.entity.Account;
import com.backend.exception.EmailSendException;
import com.backend.model.AccountCredentials;
import com.backend.service.interfaces.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    @Override
    public void sendWelcomeEmail(Account account, AccountCredentials credentials) {
        String subject = "Welcome to YBank - Account Created Successfully!";
        String body = generateWelcomeEmailContent(account, credentials);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(account.getEmail());
            helper.setSubject(subject);
            helper.setText(body, true);

            mailSender.send(message);
            log.info("Welcome email sent successfully to {}", account.getEmail());
        } catch (Exception e) {
            log.error("Failed to send welcome email: {}", e.getMessage());
            throw new EmailSendException("Failed to send welcome email", e);
        }
    }

    @Override
    public void sendOtp(String email, String otp) {

    }

    @Override
    public void sendPasswordResetEmail(String email, String resetToken) {

    }

    private String generateWelcomeEmailContent(Account account, AccountCredentials credentials) {
        return """
            <html>
            <body>
                <h2>Welcome to YBank!</h2>
                <p>Dear %s,</p>
                <p>Your bank account has been created successfully.</p>
                
                <h3>Account Details:</h3>
                <ul>
                    <li>Customer ID: %s</li>
                    <li>Account Number: %s</li>
                    <li>IFSC Code: %s</li>
                    <li>Branch: %s</li>
                </ul>
                
                <h3>Online Banking Credentials:</h3>
                <ul>
                    <li>Customer ID: %s</li>
                    <li>Temporary Password: %s</li>
                </ul>
                
                <p>Please login to our online banking portal and change your password immediately.</p>
                
                <p>Best Regards,<br>YBank Team</p>
            </body>
            </html>
            """.formatted(
                account.getAccountHolder(),
                credentials.getCustomerId(),
                credentials.getAccountNumber(),
                account.getIfscCode(),
                account.getBranchName(),
                credentials.getCustomerId(),
                credentials.getTemporaryPassword()
        );
    }
}
