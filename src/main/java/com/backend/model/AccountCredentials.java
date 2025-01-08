package com.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountCredentials {
    private String customerId;        // Example: CUS202400001
    private String accountNumber;     // Example: 1234567890
    private String temporaryPassword; // Example: TMP123456
    private String ifscCode;         // Example: YBANK0001

    // Additional helper methods if needed
    public String getMaskedAccountNumber() {
        return "XXXX" + accountNumber.substring(accountNumber.length() - 4);
    }

    public String getMaskedCustomerId() {
        return "CUS" + "XXXXX" + customerId.substring(customerId.length() - 3);
    }
}
