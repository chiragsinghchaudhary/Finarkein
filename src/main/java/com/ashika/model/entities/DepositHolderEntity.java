package com.ashika.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_holder")
public class DepositHolderEntity {

	@Id
	private String pan;
	private String type;
	private String address;
	private Boolean ckycCompliance;
	private Long dob;
	private String email;
	private String landline;
	private String mobile;
	private String name;
	private String nominee;

	public DepositHolderEntity(String pan, String type, String address, Boolean ckycCompliance, Long dob, String email,
			String landline, String mobile, String name, String nominee) {
		super();
		this.pan = pan;
		this.type = type;
		this.address = address;
		this.ckycCompliance = ckycCompliance;
		this.dob = dob;
		this.email = email;
		this.landline = landline;
		this.mobile = mobile;
		this.name = name;
		this.nominee = nominee;
	}

	protected DepositHolderEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}
