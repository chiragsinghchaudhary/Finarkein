package com.ashika.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsentNewRunRequest {
	
	@JsonProperty("customerMobileNumber")
    private String customerMobileNumber;
	
	@JsonProperty("applicationNo")
    private String applicationNo;

    @JsonProperty("consentTemplateId")
    private String consentTemplateId;

    @JsonProperty("redirectUrl")
    private String redirectUrl;

    @JsonProperty("identifiers")
    private Identifiers identifiers;

    @JsonProperty("webhook")
    private Webhook webhook;

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

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

	public Identifiers getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(Identifiers identifiers) {
		this.identifiers = identifiers;
	}

	public Webhook getWebhook() {
		return webhook;
	}

	public void setWebhook(Webhook webhook) {
		this.webhook = webhook;
	}
   
}
