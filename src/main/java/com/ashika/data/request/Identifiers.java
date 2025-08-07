package com.ashika.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Identifiers {
    @JsonProperty("email")
    private String email;

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("dob")
    private String dob;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
