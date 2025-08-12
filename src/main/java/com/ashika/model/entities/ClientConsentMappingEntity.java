package com.ashika.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client_Consent_Mapping",indexes = {
	    @Index(name = "idx_requestId", columnList = "requestId"),
	    @Index(name = "idx_pan_requestId", columnList = "pan, requestId")
	})
public class ClientConsentMappingEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String pan;	  
	@Column(unique = true)
	private String requestId; 
    private String clientCode;
    private String runType;    
    private String state;
    private String consentStatus;
    private String dataFetchStatus;
    private LocalDate dob;
    private String consentHandle;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedTime;
    
	public ClientConsentMappingEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getRunType() {
		return runType;
	}

	public void setRunType(String runType) {
		this.runType = runType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getConsentStatus() {
		return consentStatus;
	}

	public void setConsentStatus(String consentStatus) {
		this.consentStatus = consentStatus;
	}

	public String getDataFetchStatus() {
		return dataFetchStatus;
	}

	public void setDataFetchStatus(String dataFetchStatus) {
		this.dataFetchStatus = dataFetchStatus;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getConsentHandle() {
		return consentHandle;
	}

	public void setConsentHandle(String consentHandle) {
		this.consentHandle = consentHandle;
	}

	public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
}

