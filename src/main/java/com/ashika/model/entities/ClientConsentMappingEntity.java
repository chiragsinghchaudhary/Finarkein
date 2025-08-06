package com.ashika.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(ClientConsentMappingId.class)
@Table(name = "Client_Consent_Mapping")
public class ClientConsentMappingEntity {
	
	@Id
    private String pan;
	@Id
    private String requestId;
    private String clientCode;
    private String runType;    
    private String state;
    private String consentStatus;
    private String dataFetchStatus;
    private LocalDate dob;
    private String consentHandle;
    private LocalDateTime lastUpdatedTime;
    
    public ClientConsentMappingEntity(String pan, String requestId, String clientCode, String runType, String state,
			String consentStatus, String dataFetchStatus, LocalDate dob, String consentHandle,
			LocalDateTime lastUpdatedTime) {
		this.pan = pan;
		this.requestId = requestId;
		this.clientCode = clientCode;
		this.runType = runType;
		this.state = state;
		this.consentStatus = consentStatus;
		this.dataFetchStatus = dataFetchStatus;
		this.dob = dob;
		this.consentHandle = consentHandle;
		this.lastUpdatedTime = lastUpdatedTime;
	}
    
    
	protected ClientConsentMappingEntity() {
		// TODO Auto-generated constructor stub
	}


	// Getters & Setters
    public String getClientCode() { return clientCode; }
    public void setClientCode(String clientCode) { this.clientCode = clientCode; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }
    
    public String getRunType() { return runType; }
    public void setRunType(String runType) { this.runType = runType; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getConsentStatus() { return consentStatus; }
    public void setConsentStatus(String consentStatus) { this.consentStatus = consentStatus; }

    public String getDataFetchStatus() { return dataFetchStatus; }
    public void setDataFetchStatus(String dataFetchStatus) { this.dataFetchStatus = dataFetchStatus; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getConsentHandle() { return consentHandle; }
    public void setConsentHandle(String consentHandle) { this.consentHandle = consentHandle; }
	
    public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
}

