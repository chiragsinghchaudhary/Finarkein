package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class GetResultResponse extends BaseResponse {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("state")
    private State state;

    @JsonProperty("data")
    private DataDictionary data;

    @JsonProperty("addOnParams")
    private Map<String, String> addOnParams;

    // Getters & Setters
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public DataDictionary getData() { return data; }
    public void setData(DataDictionary data) { this.data = data; }

    public Map<String, String> getAddOnParams() { return addOnParams; }
    public void setAddOnParams(Map<String, String> addOnParams) { this.addOnParams = addOnParams; }
}
