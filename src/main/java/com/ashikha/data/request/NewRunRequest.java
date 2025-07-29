//Request for initiating consent + data fetch
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
}
