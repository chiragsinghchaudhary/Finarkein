package com.ashika.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "equity_holder",
    indexes = {
        @Index(name = "idx_equity_holder_pan", columnList = "pan")
    }
)
public class EquityHolderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String dob;
    private String maskedAccNumber;
    private String folioNo;
    private String accountType;
    private String landLine;
    private String dematId;
    private String address;
    private boolean ckycCompliance;
    private String linkedAccRef;
    private String mobile;
    private String pan;
    private String nominee;

    public EquityHolderEntity(
            String name,
            String email,
            String dob,
            String maskedAccNumber,
            String folioNo,
            String accountType,
            String landLine,
            String dematId,
            String address,
            boolean ckycCompliance,
            String linkedAccRef,
            String mobile,
            String pan,
            String nominee
    ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.maskedAccNumber = maskedAccNumber;
        this.folioNo = folioNo;
        this.accountType = accountType;
        this.landLine = landLine;
        this.dematId = dematId;
        this.address = address;
        this.ckycCompliance = ckycCompliance;
        this.linkedAccRef = linkedAccRef;
        this.mobile = mobile;
        this.pan = pan;
        this.nominee = nominee;
    }

    protected EquityHolderEntity() {
        // Default constructor for JPA
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getMaskedAccNumber() { return maskedAccNumber; }
    public void setMaskedAccNumber(String maskedAccNumber) { this.maskedAccNumber = maskedAccNumber; }

    public String getFolioNo() { return folioNo; }
    public void setFolioNo(String folioNo) { this.folioNo = folioNo; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getLandLine() { return landLine; }
    public void setLandLine(String landLine) { this.landLine = landLine; }

    public String getDematId() { return dematId; }
    public void setDematId(String dematId) { this.dematId = dematId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public boolean getCkycCompliance() { return ckycCompliance; }
    public void setCkycCompliance(boolean ckycCompliance) { this.ckycCompliance = ckycCompliance; }

    public String getLinkedAccRef() { return linkedAccRef; }
    public void setLinkedAccRef(String linkedAccRef) { this.linkedAccRef = linkedAccRef; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getNominee() { return nominee; }
    public void setNominee(String nominee) { this.nominee = nominee; }
}
