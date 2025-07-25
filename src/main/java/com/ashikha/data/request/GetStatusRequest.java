//Holds path parameters (workspace, flowId, requestId) for status checks
package com.ashikha.data.request;

public class GetStatusRequest {

    private String workspace;
    private String flowId;
    private String requestId;

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
