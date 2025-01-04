package com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private String branchName;
    private String ifscCode;
    private String address;
    private String contactNumber;
    private String emailId;
    private String fullName;
    private String email;
    private String mobile;
    private String panCardNumber;
    private String aadhaarNumber;

    @Lob
    private byte[] passportPhoto;

    @Lob
    private byte[] panCardImage;

    @Lob
    private byte[] aadhaarCardImage;

    @Lob
    private byte[] electricityBillImage;

    private LocalDateTime registrationDate;
    private String accountStatus;
    private String bankName;
    private String bankAddress;
    private String bankContactNumber;
    private String bankEmail;
    private String bankFullName;
    private String bankEmailId;
    private String bankMobile;

}
