package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStatusResponse {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("state")
    private State state;

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
