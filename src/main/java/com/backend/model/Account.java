package com.backend.model;

import com.backend.enums.EnumAccountStatus;
import com.backend.enums.EnumAccountType;
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

    @Column(name = "account_holder_name")
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

    @Column(name = "pan_card_number")
    private String panCardNumber;

    @Column(name = "aadhaar_number")
    private String aadhaarNumber;

    @Column(name = "passport_photo")
    private byte[] passportPhoto;

    @Column(name = "pan_card_image")
    private byte[] panCardImage;

    @Column(name = "aadhaar_card_image")
    private byte[] aadhaarCardImage;

    @Column(name = "electricity_bill_image")
    private byte[] electricityBillImage;

    @Column(name = "balance")
    private Double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private EnumAccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EnumAccountStatus status;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    private Bank bank;
}
