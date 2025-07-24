//Request for initiating consent + data fetch
package com.ashikha.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class NewRunRequest {

    @JsonProperty("consentTemplateId")
    private String consentTemplateId;

    @JsonProperty("redirectUrl")
    private String redirectUrl;

    @JsonProperty("user")
    private User user;

    @JsonProperty("webhook")
    private Webhook webhook;

    public static class User {
        @JsonProperty("clientUserId")
        private String clientUserId;

        @JsonProperty("mobileNumber")
        private String mobileNumber;

        @JsonProperty("pan")
        private String pan;

        @JsonProperty("dob")
        private String dob;

        public String getClientUserId() {
            return clientUserId;
        }

        public void setClientUserId(String clientUserId) {
            this.clientUserId = clientUserId;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getPan() {
            return pan;
        }

        public void setPan(String pan) {
            this.pan = pan;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }
    }

    public static class Webhook {
        @JsonProperty("consentStatus")
        private String consentStatus;

        @JsonProperty("dataPush")
        private String dataPush;

        @JsonProperty("flowRunStatus")
        private String flowRunStatus;

        @JsonProperty("addOnParams")
        private Map<String, String> addOnParams;

        public String getConsentStatus() {
            return consentStatus;
        }

        public void setConsentStatus(String consentStatus) {
            this.consentStatus = consentStatus;
        }

        public String getDataPush() {
            return dataPush;
        }

        public void setDataPush(String dataPush) {
            this.dataPush = dataPush;
        }

        public String getFlowRunStatus() {
            return flowRunStatus;
        }

        public void setFlowRunStatus(String flowRunStatus) {
            this.flowRunStatus = flowRunStatus;
        }

        public Map<String, String> getAddOnParams() {
            return addOnParams;
        }

        public void setAddOnParams(Map<String, String> addOnParams) {
            this.addOnParams = addOnParams;
        }
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
