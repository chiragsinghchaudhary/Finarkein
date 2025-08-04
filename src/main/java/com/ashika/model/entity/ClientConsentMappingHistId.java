package com.ashika.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ClientConsentMappingHistId implements Serializable {
	private String pan;
    private String requestId;
    private LocalDateTime lastUpdatedTime;

    // Getters & Setters
    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public LocalDateTime getLastUpdatedTime() { return lastUpdatedTime; }
    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) { this.lastUpdatedTime = lastUpdatedTime; }
}
