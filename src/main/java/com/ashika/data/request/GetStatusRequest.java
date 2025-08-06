//Holds path parameters (workspace, flowId, requestId) for status checks
package com.ashika.data.request;

public class GetStatusRequest {

    private String requestId;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
