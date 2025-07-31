package com.ashikha.data.response;

public class FinarkinResultResponse {
    private String requestId;
    private Object resultData; // Replace Object with actual result fields when known

    // Getters and setters
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
