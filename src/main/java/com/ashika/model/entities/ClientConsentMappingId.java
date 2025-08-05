package com.ashika.model.entities;

import java.io.Serializable;

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
    
}
