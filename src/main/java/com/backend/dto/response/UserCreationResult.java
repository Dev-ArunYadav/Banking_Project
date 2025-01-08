package com.backend.dto.response;

import com.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreationResult {
    private User user;
    private String plainPassword;
}
