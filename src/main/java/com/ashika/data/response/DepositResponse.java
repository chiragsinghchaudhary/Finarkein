package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DepositResponse {

    @JsonProperty("holder")
    private List<DepositHolder> holder = new ArrayList<>();

    @JsonProperty("summary")
    private List<DepositSummary> summary  = new ArrayList<>();

    @JsonProperty("transactions")
    private List<DepositTransaction> transactions  = new ArrayList<>();

    // Getters & Setters
    public List<DepositHolder> getHolder() { return holder; }
    public void setHolder(List<DepositHolder> holder) { this.holder = holder; }

    public List<DepositSummary> getSummary() { return summary; }
    public void setSummary(List<DepositSummary> summary) { this.summary = summary; }

    public List<DepositTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<DepositTransaction> transactions) { this.transactions = transactions; }
}
