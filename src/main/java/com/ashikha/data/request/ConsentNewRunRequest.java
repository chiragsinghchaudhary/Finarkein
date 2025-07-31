package com.ashikha.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsentNewRunRequest {

    @JsonProperty("consentTemplateId")
    private String consentTemplateId;

    @JsonProperty("redirectUrl")
    private String redirectUrl;

    @JsonProperty("user")
    private User user;

    @JsonProperty("webhook")
    private Webhook webhook;

    // No-arg constructor
    public ConsentNewRunRequest() {}

    // Parameterized constructor
    public ConsentNewRunRequest(String consentTemplateId, String redirectUrl, User user, Webhook webhook) {
        this.consentTemplateId = consentTemplateId;
        this.redirectUrl = redirectUrl;
        this.user = user;
        this.webhook = webhook;
    }

    // Getters and Setters
    public String getConsentTemplateId() {
        return consentTemplateId;
    }

    public void setConsentTemplateId(String consentTemplateId) {
        this.consentTemplateId = consentTemplateId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Webhook getWebhook() {
        return webhook;
    }
 public void setWebhook(Webhook webhook) {
        this.webhook = webhook;
    }
}
