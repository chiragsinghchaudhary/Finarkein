package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DepositResponse {

    @JsonProperty("profile")
    private List<DepositHolder> profile;

    @JsonProperty("summary")
    private List<DepositSummary> summary;

    @JsonProperty("transactions")
    private List<DepositTransaction> transactions;

    // Getters & Setters
    public List<DepositHolder> getProfile() { return profile; }
    public void setProfile(List<DepositHolder> profile) { this.profile = profile; }

    public List<DepositSummary> getSummary() { return summary; }
    public void setSummary(List<DepositSummary> summary) { this.summary = summary; }

    public List<DepositTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<DepositTransaction> transactions) { this.transactions = transactions; }
}
