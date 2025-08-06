package com.ashika.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
public class RecurringNewRunRequest {

    @JsonProperty("consentHandle")
    private String consentHandle;

    @JsonProperty("fetchFilter")
    private FetchFilter fetchFilter;

    @JsonProperty("webhook")
    private Webhook webhook;

    // No-arg constructor
    public RecurringNewRunRequest() {}

    // Parameterized constructor
    public RecurringNewRunRequest(String consentHandle, FetchFilter fetchFilter, Webhook webhook) {
        this.consentHandle = consentHandle;
        this.fetchFilter = fetchFilter;
        this.webhook = webhook;
    }

    // Getters and Setters
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
