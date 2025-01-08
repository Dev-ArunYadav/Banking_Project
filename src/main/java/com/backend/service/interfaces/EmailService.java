package com.backend.service.interfaces;

import com.backend.model.Account;

public interface EmailService {
    void sendCredentialsEmail(String email, Long customerId, String plainPassword);
    void sendAccountDetailsEmail(Account account);
}
