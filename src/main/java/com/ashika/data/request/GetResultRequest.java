//Request for recurring data fetch (after consent)
package com.ashika.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetResultRequest {

    @JsonProperty("consentHandle")
    private String consentHandle;

    @JsonProperty("fetchFilter")
    private FetchFilter fetchFilter;

    @JsonProperty("webhook")
    private Webhook webhook;

    public String getConsentHandle() {
        return consentHandle;
    }

    public void setConsentHandle(String consentHandle) {
        this.consentHandle = consentHandle;
    }

    public FetchFilter getFetchFilter() {
        return fetchFilter;
    }

    public void setFetchFilter(FetchFilter fetchFilter) {
        this.fetchFilter = fetchFilter;
    }

    public Webhook getWebhook() {
        return webhook;
    }

    public void setWebhook(Webhook webhook) {
        this.webhook = webhook;
    }
}
