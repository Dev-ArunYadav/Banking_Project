package com.backend.dto.response;

import com.backend.entity.EnumAccountStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountCreationResponseDTO {
    private String accountNumber;
    private String customerId;
    private String temporaryPassword;
    private String accountHolder;
    private String ifscCode;
    private String bankName;
    private String branchName;
    private String email;
    private String phoneNumber;
    private EnumAccountStatus status;
}
