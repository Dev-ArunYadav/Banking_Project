package com.backend.service.impl;

import com.backend.model.Account;
import com.backend.service.interfaces.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;


    @Override
    public void sendCredentialsEmail(String email, Long customerId, String password) {
        try {
            Context context = new Context();
            context.setVariable("customerId", customerId);
            context.setVariable("password", password);

            String htmlContent = templateEngine.process("credentials-email", context);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            helper.setSubject("Your Banking Credentials");
            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send credentials email", e);
        }
    }
    @Override
    public void sendAccountDetailsEmail(Account account) {
        try {
            Context context = new Context();
            context.setVariable("account", account);

            String htmlContent = templateEngine.process("account-details-email", context);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(account.getEmail());
            helper.setSubject("Your Account Details");
            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send account details email", e);
        }
    }
}