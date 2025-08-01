package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DepositResponse {

    @JsonProperty("holder")
    private List<DepositHolder> holder;

    @JsonProperty("summary")
    private List<DepositSummary> summary;

    @JsonProperty("transactions")
    private List<DepositTransaction> transactions;

    // Getters & Setters
    public List<DepositHolder> getHolder() { return holder; }
    public void setHolder(List<DepositHolder> holder) { this.holder = holder; }

    public List<DepositSummary> getSummary() { return summary; }
    public void setSummary(List<DepositSummary> summary) { this.summary = summary; }

    public List<DepositTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<DepositTransaction> transactions) { this.transactions = transactions; }
}
