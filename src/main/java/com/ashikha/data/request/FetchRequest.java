//Request for recurring data fetch (after consent)
package com.ashikha.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class FetchRequest {

    @JsonProperty("consentHandle")
    private String consentHandle;

    @JsonProperty("fetchFilter")
    private FetchFilter fetchFilter;

    @JsonProperty("webhook")
    private Webhook webhook;

    public static class FetchFilter {
        @JsonProperty("fiTypes")
        private List<String> fiTypes;

        @JsonProperty("fips")
        private List<String> fips;

        @JsonProperty("accountLinkRefNumbers")
        private List<String> accountLinkRefNumbers;

        public List<String> getFiTypes() {
            return fiTypes;
        }

        public void setFiTypes(List<String> fiTypes) {
            this.fiTypes = fiTypes;
        }

        public List<String> getFips() {
            return fips;
        }

        public void setFips(List<String> fips) {
            this.fips = fips;
        }

        public List<String> getAccountLinkRefNumbers() {
            return accountLinkRefNumbers;
        }

        public void setAccountLinkRefNumbers(List<String> accountLinkRefNumbers) {
            this.accountLinkRefNumbers = accountLinkRefNumbers;
        }
    }

    public static class Webhook {
        @JsonProperty("dataPush")
        private String dataPush;

        @JsonProperty("flowRunStatus")
        private String flowRunStatus;

        @JsonProperty("addOnParams")
        private Map<String, String> addOnParams;

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
