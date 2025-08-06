package com.ashika.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mf_holder")
public class MFHolderEntity {

	@Id
	private String pan;
	private String address;
	private String dematId;
	private Long dob;
	private String email;
	private String folioNo;
	private Boolean kycCompliance;
	private String landline;
	private String mobile;
	private String name;
	private String nominee;

	public MFHolderEntity(String pan, String address, String dematId, Long dob, String email, String folioNo,
			Boolean kycCompliance, String landline, String mobile, String name, String nominee) {
		super();
		this.pan = pan;
		this.address = address;
		this.dematId = dematId;
		this.dob = dob;
		this.email = email;
		this.folioNo = folioNo;
		this.kycCompliance = kycCompliance;
		this.landline = landline;
		this.mobile = mobile;
		this.name = name;
		this.nominee = nominee;
	}

	protected MFHolderEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
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

	public String getFolioNo() {
		return folioNo;
	}

	public void setFolioNo(String folioNo) {
		this.folioNo = folioNo;
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
}
