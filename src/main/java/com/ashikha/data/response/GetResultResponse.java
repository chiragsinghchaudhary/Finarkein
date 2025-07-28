package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class GetResultResponse {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("state")
    private State state;  // Non-static inner object

    @JsonProperty("data")
    private DataWrapper data;

    @JsonProperty("addOnParams")
    private Map<String, String> addOnParams;

    // ========== Separate Non-Static State Class ==========
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

    // ========== Data Wrapper ==========
    public static class DataWrapper {

        @JsonProperty("deposit")
        private DepositResponse deposit;

        @JsonProperty("mf")
        private MFResponse mf;

        @JsonProperty("equity")
        private EquityResponse equity;

        // Getters & Setters
        public DepositResponse getDeposit() { return deposit; }
        public void setDeposit(DepositResponse deposit) { this.deposit = deposit; }

        public MFResponse getMf() { return mf; }
        public void setMf(MFResponse mf) { this.mf = mf; }

        public EquityResponse getEquity() { return equity; }
        public void setEquity(EquityResponse equity) { this.equity = equity; }
    }

    // ========== Main Getters & Setters ==========
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public DataWrapper getData() { return data; }
    public void setData(DataWrapper data) { this.data = data; }

    public Map<String, String> getAddOnParams() { return addOnParams; }
    public void setAddOnParams(Map<String, String> addOnParams) { this.addOnParams = addOnParams; }
}

