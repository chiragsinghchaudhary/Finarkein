package com.ashikha.data.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Webhook {
     @JsonProperty("consentStatus")
    private String consentStatus;
    
    @JsonProperty("dataPush")
    private String dataPush;

    @JsonProperty("flowRunStatus")
    private String flowRunStatus;

    @JsonProperty("addOnParams")
    private Map<String, String> addOnParams;

     public String getConsentStatus() {
        return consentStatus;
    }

    public String getDataPush() {
        return dataPush;
    }

    public void setDataPush(String dataPush) {
        this.dataPush = dataPush;
    }

    public String getFlowRunStatus() {
        return flowRunStatus;
    }

    public void setFlowRunStatus(String flowRunStatus) {
        this.flowRunStatus = flowRunStatus;
    }

    public Map<String, String> getAddOnParams() {
        return addOnParams;
    }

    public void setAddOnParams(Map<String, String> addOnParams) {
        this.addOnParams = addOnParams;
    }
}
