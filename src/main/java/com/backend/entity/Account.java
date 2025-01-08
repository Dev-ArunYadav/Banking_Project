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
//    To open the account required Details of Users
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "account_holder")
    private String accountHolder;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pincode")
    private String pincode;

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

//    Account Details

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "account_type")
    private EnumAccountType accountType;

    @Column(name = "balance")
    private Double balance;

    private String bankAddress;
    private String bankContactNumber;
    private String bankEmail;

    @Column(name = "status")
    private EnumAccountStatus status;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
