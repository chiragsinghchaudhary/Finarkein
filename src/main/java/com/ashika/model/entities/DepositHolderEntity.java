package com.ashika.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_holder")
public class DepositHolderEntity {

    private String name;
    private String email;
    private Long dob;
    
    @Id
    private String maskedAccNumber;
    private String accountType;
    private String landLine;
    private String address;
    private Boolean ckycCompliance;
    private String linkedAccRef;
    private String type;
    private String mobile;
    private String pan;
    private String nominee;

    public DepositHolderEntity(String name, String email, Long dob, String maskedAccNumber, String accountType,
                                String landLine, String address, Boolean ckycCompliance, String linkedAccRef,
                                String type, String mobile, String pan, String nominee) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.maskedAccNumber = maskedAccNumber;
        this.accountType = accountType;
        this.landLine = landLine;
        this.address = address;
        this.ckycCompliance = ckycCompliance;
        this.linkedAccRef = linkedAccRef;
        this.type = type;
        this.mobile = mobile;
        this.pan = pan;
        this.nominee = nominee;
    }

    protected DepositHolderEntity() {
        // Default constructor for JPA
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }

    public String getMaskedAccNumber() {
        return maskedAccNumber;
    }

    public void setMaskedAccNumber(String maskedAccNumber) {
        this.maskedAccNumber = maskedAccNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getCkycCompliance() {
        return ckycCompliance;
    }

    public void setCkycCompliance(Boolean ckycCompliance) {
        this.ckycCompliance = ckycCompliance;
    }

    public String getLinkedAccRef() {
        return linkedAccRef;
    }

    public void setLinkedAccRef(String linkedAccRef) {
        this.linkedAccRef = linkedAccRef;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }
}
