package com.ashika.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetTypeRequest {

    @JsonProperty("runType")
    private String runType;

	public String getRunType() {
		return runType;
	}

	public void setRunType(String runType) {
		this.runType = runType;
	}
    
}