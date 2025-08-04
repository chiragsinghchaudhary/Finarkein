package com.ashika.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(ClientConsentMappingHistId.class)
@Table(name = "Client_Consent_Mapping_Hist")
public class ClientConsentMappingHistEntity {
	
	private String clientCode;

    @Id
    private String pan;
    
    private String runType;

    
    private String state;

    
    private String consentStatus;

    
    private String dataFetchStatus;

    private LocalDate dob;
    private String email;
    
    @Id
    private String requestId;
    
    private String consentHandle;
    
    @Id
    private LocalDateTime lastUpdatedTime;

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

    public LocalDateTime getLastUpdatedTime() { return lastUpdatedTime; }
    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) { this.lastUpdatedTime = lastUpdatedTime; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getConsentHandle() { return consentHandle; }
    public void setConsentHandle(String consentHandle) { this.consentHandle = consentHandle; }
}
