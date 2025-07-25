//To extract requestId, redirectUrl, and journeyId
package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewRunResponse {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("redirectUrl")
    private String redirectUrl;

    @JsonProperty("journeyId")
    private String journeyId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(String journeyId) {
        this.journeyId = journeyId;
    }
}
