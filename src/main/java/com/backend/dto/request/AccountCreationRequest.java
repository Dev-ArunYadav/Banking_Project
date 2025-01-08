package com.backend.dto.request;

import com.backend.enums.EnumAccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreationRequest {
    // Personal Details
    private String accountHolder;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;

    // Document Details
    private String panCardNumber;
    private String aadhaarNumber;
    private MultipartFile passportPhoto;
    private MultipartFile panCardImage;
    private MultipartFile aadhaarCardImage;
    private MultipartFile electricityBillImage;

    // Account Type
    private EnumAccountType accountType;

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public MultipartFile getPassportPhoto() {
        return passportPhoto;
    }

    public void setPassportPhoto(MultipartFile passportPhoto) {
        this.passportPhoto = passportPhoto;
    }

    public MultipartFile getPanCardImage() {
        return panCardImage;
    }

    public void setPanCardImage(MultipartFile panCardImage) {
        this.panCardImage = panCardImage;
    }

    public MultipartFile getAadhaarCardImage() {
        return aadhaarCardImage;
    }

    public void setAadhaarCardImage(MultipartFile aadhaarCardImage) {
        this.aadhaarCardImage = aadhaarCardImage;
    }

    public MultipartFile getElectricityBillImage() {
        return electricityBillImage;
    }

    public void setElectricityBillImage(MultipartFile electricityBillImage) {
        this.electricityBillImage = electricityBillImage;
    }

    public EnumAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(EnumAccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "AccountCreationRequest{" +
                "accountHolder='" + accountHolder + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode='" + pincode + '\'' +
                ", panCardNumber='" + panCardNumber + '\'' +
                ", aadhaarNumber='" + aadhaarNumber + '\'' +
                ", passportPhoto=" + passportPhoto +
                ", panCardImage=" + panCardImage +
                ", aadhaarCardImage=" + aadhaarCardImage +
                ", electricityBillImage=" + electricityBillImage +
                ", accountType=" + accountType +
                '}';
    }
}