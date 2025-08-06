package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositHolder {

    @JsonProperty("type")
    private String type;

    @JsonProperty("address")
    private String address;

    @JsonProperty("ckycCompliance")
    private Boolean ckycCompliance;

    @JsonProperty("dob")
    private Long dob;

    @JsonProperty("email")
    private String email;

    @JsonProperty("landline")
    private String landline;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nominee")
    private String nominee;

    @JsonProperty("pan")
    private String pan;

    // Getters & Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Boolean getCkycCompliance() { return ckycCompliance; }
    public void setCkycCompliance(Boolean ckycCompliance) { this.ckycCompliance = ckycCompliance; }

    public Long getDob() { return dob; }
    public void setDob(Long dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLandline() { return landline; }
    public void setLandline(String landline) { this.landline = landline; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNominee() { return nominee; }
    public void setNominee(String nominee) { this.nominee = nominee; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }
}
