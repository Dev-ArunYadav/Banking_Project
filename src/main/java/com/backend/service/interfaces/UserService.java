package com.backend.service.interfaces;

import com.backend.model.Account;
import com.backend.model.User;

public interface UserService {
    User createUser(Account account);
}
