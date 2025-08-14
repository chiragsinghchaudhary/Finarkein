package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecurringNewRunResponse {

	@JsonProperty("requestId")
	private String requestId;

	// No-arg constructor
	public RecurringNewRunResponse() {
	}

	// Parameterized constructor
	public RecurringNewRunResponse(String requestId) {
		this.requestId = requestId;
	}

	// Getter and Setter
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
