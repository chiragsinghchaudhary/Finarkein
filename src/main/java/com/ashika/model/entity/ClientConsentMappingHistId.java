package com.ashika.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ClientConsentMappingHistId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2082363610476215337L;
	private String pan;
    private String requestId;
    private LocalDateTime lastUpdatedTime;

    // Getters & Setters
    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }
    
    public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

    public LocalDateTime getLastUpdatedTime() { return lastUpdatedTime; }
    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) { this.lastUpdatedTime = lastUpdatedTime; }
}
