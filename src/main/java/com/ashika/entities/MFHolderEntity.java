package com.ashika.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mf_holder", indexes = {
        @Index(name = "idx_mf_holder_pan", columnList = "pan")
})
public class MFHolderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String maskedDematID;
    private String email;
    private Long dob;
    private String maskedAccNumber;
    private String folioNo;
    private String accountType;       // MUTUAL_FUNDS in example
    private String landLine;          // Changed from landline to match JSON key
    private String dematId;
    private String address;
    private String ckycCompliance;    // Changed from Boolean to String ("Completed")
    private String linkedAccRef;
    private String mobile;
    private String pan;
    private String maskedFolioNo;
    private String nominee;

    public MFHolderEntity(String name, String maskedDematID, String email, Long dob, String maskedAccNumber,
                          String folioNo, String accountType, String landLine, String dematId, String address,
                          String ckycCompliance, String linkedAccRef, String mobile, String pan,
                          String maskedFolioNo, String nominee) {
        this.name = name;
        this.maskedDematID = maskedDematID;
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
        this.maskedFolioNo = maskedFolioNo;
        this.nominee = nominee;
    }

    protected MFHolderEntity() {
        // Default constructor for JPA
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMaskedDematID() { return maskedDematID; }
    public void setMaskedDematID(String maskedDematID) { this.maskedDematID = maskedDematID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getDob() { return dob; }
    public void setDob(Long dob) { this.dob = dob; }

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

    public String getCkycCompliance() { return ckycCompliance; }
    public void setCkycCompliance(String ckycCompliance) { this.ckycCompliance = ckycCompliance; }

    public String getLinkedAccRef() { return linkedAccRef; }
    public void setLinkedAccRef(String linkedAccRef) { this.linkedAccRef = linkedAccRef; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getMaskedFolioNo() { return maskedFolioNo; }
    public void setMaskedFolioNo(String maskedFolioNo) { this.maskedFolioNo = maskedFolioNo; }

    public String getNominee() { return nominee; }
    public void setNominee(String nominee) { this.nominee = nominee; }
}
