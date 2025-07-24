package com.ashikha.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response structure for Deposit account data.
 */
public class DepositResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("dob")
    private String dob; // Can be changed to LocalDate or Long if needed (epoch)

    @JsonProperty("maskedAccNumber")
    private String maskedAccNumber;

    @JsonProperty("account_type")
    private String accountType;

    @JsonProperty("landLine")
    private String landLine;

    @JsonProperty("address")
    private String address;

    @JsonProperty("ckycCompliance")
    private Boolean ckycCompliance;

    @JsonProperty("linkedAccRef")
    private String linkedAccRef;

    @JsonProperty("type")
    private String type;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("nominee")
    private String nominee;

    // Getters and Setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getMaskedAccNumber() { return maskedAccNumber; }
    public void setMaskedAccNumber(String maskedAccNumber) { this.maskedAccNumber = maskedAccNumber; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getLandLine() { return landLine; }
    public void setLandLine(String landLine) { this.landLine = landLine; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Boolean getCkycCompliance() { return ckycCompliance; }
    public void setCkycCompliance(Boolean ckycCompliance) { this.ckycCompliance = ckycCompliance; }

    public String getLinkedAccRef() { return linkedAccRef; }
    public void setLinkedAccRef(String linkedAccRef) { this.linkedAccRef = linkedAccRef; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getNominee() { return nominee; }
    public void setNominee(String nominee) { this.nominee = nominee; }
}
