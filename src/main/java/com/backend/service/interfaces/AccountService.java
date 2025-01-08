package com.backend.service.interfaces;

import com.backend.dto.request.AccountCreationRequest;
import com.backend.model.Account;

import java.io.IOException;

public interface AccountService {

    Account createAccount(AccountCreationRequest request) throws IOException;
}
