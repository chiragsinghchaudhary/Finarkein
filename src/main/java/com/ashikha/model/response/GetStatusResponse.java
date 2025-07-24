package com.ashikha.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStatusResponse {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("state")
    private State state;

    public static class State {
        @JsonProperty("state")
        private String state;

        @JsonProperty("consentStatus")
        private String consentStatus;

        @JsonProperty("dataFetchStatus")
        private String dataFetchStatus;

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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
