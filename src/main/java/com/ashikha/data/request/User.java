package com.ashikha.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("clientUserId")
    private String clientUserId;

    @JsonProperty("mobileNumber")
    private String mobileNumber;

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("dob")
    private String dob;

    public String getClientUserId() {
        return clientUserId;
    }

    public void setClientUserId(String clientUserId) {
        this.clientUserId = clientUserId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
