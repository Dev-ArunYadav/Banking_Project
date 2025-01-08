package com.backend.dto.request;

import com.backend.entity.EnumAccountType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class AccountCreationRequestDTO {
    @NotBlank(message = "Account holder name is required")
    private String accountHolder;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Date of birth is required")
    private String dateOfBirth;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String phoneNumber;

    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN number")
    private String panCardNumber;

    @Pattern(regexp = "^[0-9]{12}$", message = "Invalid Aadhaar number")
    private String aadhaarNumber;

    private MultipartFile passportPhoto;
    private MultipartFile panCardImage;
    private MultipartFile aadhaarCardImage;
    private MultipartFile electricityBillImage;

    @NotNull(message = "Account type is required")
    private EnumAccountType accountType;
}
