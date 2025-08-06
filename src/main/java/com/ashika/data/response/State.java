package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class State {

    @JsonProperty("state")
    private String state;

    @JsonProperty("consentStatus")
    private String consentStatus;

    @JsonProperty("dataFetchStatus")
    private String dataFetchStatus;

    // Getters & Setters
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getConsentStatus() { return consentStatus; }
    public void setConsentStatus(String consentStatus) { this.consentStatus = consentStatus; }

    public String getDataFetchStatus() { return dataFetchStatus; }
    public void setDataFetchStatus(String dataFetchStatus) { this.dataFetchStatus = dataFetchStatus; }
}

