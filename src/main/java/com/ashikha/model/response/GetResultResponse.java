//	For parsing results (used in Get Result API)

package com.ashikha.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class GetResultResponse {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("state")
    private State state;

    @JsonProperty("data")
    private Object data;

    @JsonProperty("addOnParams")
    private Map<String, String> addOnParams;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, String> getAddOnParams() {
        return addOnParams;
    }

    public void setAddOnParams(Map<String, String> addOnParams) {
        this.addOnParams = addOnParams;
    }
}
