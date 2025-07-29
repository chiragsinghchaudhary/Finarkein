package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MFResponse {

    @JsonProperty("profile")
    private List<MFHolder> profile;

    @JsonProperty("summary")
    private List<MFSummary> summary;

    @JsonProperty("transactions")
    private List<MFTransaction> transactions;

    // ===== Main Getters & Setters =====
    public List<MFHolder> getProfile() { return profile; }
    public void setProfile(List<MFHolder> profile) { this.profile = profile; }

    public List<MFSummary> getSummary() { return summary; }
    public void setSummary(List<MFSummary> summary) { this.summary = summary; }

    public List<MFTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<MFTransaction> transactions) { this.transactions = transactions; }
}
