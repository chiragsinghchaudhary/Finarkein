package com.ashika.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ClientConsentMappingHistId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2082363610476215337L;
	private String pan;
	private String requestId;
	private LocalDateTime lastUpdatedTime;

	// Getters & Setters
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

	public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lastUpdatedTime, pan, requestId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientConsentMappingHistId other = (ClientConsentMappingHistId) obj;
		return Objects.equals(lastUpdatedTime, other.lastUpdatedTime) && Objects.equals(pan, other.pan)
				&& Objects.equals(requestId, other.requestId);
	}

}
