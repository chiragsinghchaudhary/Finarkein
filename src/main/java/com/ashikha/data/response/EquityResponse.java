package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class EquityResponse {

    @JsonProperty("profile")
    private List<EquityProfile> profile;

    @JsonProperty("summary")
    private List<EquitySummary> summary;

    @JsonProperty("transactions")
    private List<EquityTransaction> transactions;

    // ===== Main Getters & Setters =====
    public List<EquityProfile> getProfile() { return profile; }
    public void setProfile(List<EquityProfile> profile) { this.profile = profile; }

    public List<EquitySummary> getSummary() { return summary; }
    public void setSummary(List<EquitySummary> summary) { this.summary = summary; }

    public List<EquityTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<EquityTransaction> transactions) { this.transactions = transactions; }
}

