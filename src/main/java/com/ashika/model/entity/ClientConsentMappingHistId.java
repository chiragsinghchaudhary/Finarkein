package com.ashika.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ClientConsentMappingHistId implements Serializable {
    private String clientCode;
    private String pan;
    private String state;
    private String consentStatus;
    private String dataFetchStatus;
    private LocalDateTime lastUpdatedTime;

    // Getters & Setters
    public String getClientCode() { return clientCode; }
    public void setClientCode(String clientCode) { this.clientCode = clientCode; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getConsentStatus() { return consentStatus; }
    public void setConsentStatus(String consentStatus) { this.consentStatus = consentStatus; }

    public String getDataFetchStatus() { return dataFetchStatus; }
    public void setDataFetchStatus(String dataFetchStatus) { this.dataFetchStatus = dataFetchStatus; }

    public LocalDateTime getLastUpdatedTime() { return lastUpdatedTime; }
    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) { this.lastUpdatedTime = lastUpdatedTime; }
}
