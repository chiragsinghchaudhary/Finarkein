package com.ashika.model.entities;

import java.io.Serializable;
import java.util.Objects;

//Composite key class
public class ClientConsentMappingId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6358170034946600057L;
	private String pan;
	private String requestId;

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

	@Override
	public int hashCode() {
		return Objects.hash(pan, requestId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientConsentMappingId other = (ClientConsentMappingId) obj;
		return Objects.equals(pan, other.pan) && Objects.equals(requestId, other.requestId);
	}

}
