package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MutualFundsHolder {

    @JsonProperty("name")
    private String name;

    @JsonProperty("maskedDematID")
    private String maskedDematID;

    @JsonProperty("email")
    private String email;

    @JsonProperty("dob")
    private Long dob;

    @JsonProperty("maskedAccNumber")
    private String maskedAccNumber;

    @JsonProperty("folioNo")
    private String folioNo;

    @JsonProperty("account_type")
    private String accountType;

    @JsonProperty("landLine")
    private String landLine;

    @JsonProperty("dematId")
    private String dematId;

    @JsonProperty("address")
    private String address;

    @JsonProperty("ckycCompliance")
    private String ckycCompliance;

    @JsonProperty("linkedAccRef")
    private String linkedAccRef;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("maskedFolioNo")
    private String maskedFolioNo;

    @JsonProperty("nominee")
    private String nominee;

    // Getters & Setters
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
