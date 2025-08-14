package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsentNewRunResponse extends BaseResponse {

	@JsonProperty("requestId")
	private String requestId;

	@JsonProperty("consentHandle")
	private String consentHandle;

	@JsonProperty("redirectUrl")
	private String redirectUrl;

	// No-arg constructor
	public ConsentNewRunResponse() {
	}

	// Parameterized constructor
	public ConsentNewRunResponse(String requestId, String consentHandle, String redirectUrl) {
		this.requestId = requestId;
		this.consentHandle = consentHandle;
		this.redirectUrl = redirectUrl;
	}

	// Getters and Setters
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getConsentHandle() {
		return consentHandle;
	}

	public void setConsentHandle(String consentHandle) {
		this.consentHandle = consentHandle;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
