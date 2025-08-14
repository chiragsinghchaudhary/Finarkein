package com.ashika.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "equity_holder",indexes = {
	    @Index(name = "idx_equity_holder_pan", columnList = "pan")
	})
public class EquityHolderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String address;
    private String dematId;
    private Long dob;
    private String email;
    private Boolean kycCompliance;
    private String landline;
    private String mobile;
    private String name;
    private String nominee;
    private String pan;

    public EquityHolderEntity(String address, String dematId, Long dob, String email, Boolean kycCompliance,
                               String landline, String mobile, String name, String nominee, String pan) {
        this.address = address;
        this.dematId = dematId;
        this.dob = dob;
        this.email = email;
        this.kycCompliance = kycCompliance;
        this.landline = landline;
        this.mobile = mobile;
        this.name = name;
        this.nominee = nominee;
        this.pan = pan;
    }

    protected EquityHolderEntity() {
        // Default constructor for JPA
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDematId() {
        return dematId;
    }

    public void setDematId(String dematId) {
        this.dematId = dematId;
    }

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getKycCompliance() {
        return kycCompliance;
    }

    public void setKycCompliance(Boolean kycCompliance) {
        this.kycCompliance = kycCompliance;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
