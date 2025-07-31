package com.ashikha.data.response;

public class FinarkinStatusResponse {
    private String requestId;
    private String state;
    private String consentStatus;
    private String dataFetchStatus;

    // Getters and setters
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConsentStatus() {
        return consentStatus;
    }

    public void setConsentStatus(String consentStatus) {
        this.consentStatus = consentStatus;
    }

    public String getDataFetchStatus() {
        return dataFetchStatus;
    }

    public void setDataFetchStatus(String dataFetchStatus) {
        this.dataFetchStatus = dataFetchStatus;
    }
}
