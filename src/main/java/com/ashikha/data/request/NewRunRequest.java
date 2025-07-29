// Request for initiating consent + data fetch
package com.ashikha.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewRunRequest {

    @JsonProperty("consentTemplateId")
    private String consentTemplateId;

    @JsonProperty("redirectUrl")
    private String redirectUrl;

    @JsonProperty("user")
    private User user;

    @JsonProperty("webhook")
    private Webhook webhook;

    // Getter and Setter for consentTemplateId
    public String getConsentTemplateId() {
        return consentTemplateId;
    }

    public void setConsentTemplateId(String consentTemplateId) {
        this.consentTemplateId = consentTemplateId;
    }

    // Getter and Setter for redirectUrl
    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    // Getter and Setter for user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Getter and Setter for webhook
    public Webhook getWebhook() {
        return webhook;
    }

    public void setWebhook(Webhook webhook) {
        this.webhook = webhook;
    }
}
