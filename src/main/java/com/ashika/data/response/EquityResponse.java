package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class EquityResponse {

    @JsonProperty("holder")
    private List<EquityHolder> holder = new ArrayList<>();

    @JsonProperty("summary")
    private List<EquitySummary> summary = new ArrayList<>();

    @JsonProperty("transactions")
    private List<EquityTransaction> transactions = new ArrayList<>();

    // ===== Main Getters & Setters =====
    public List<EquityHolder> getHolder() { return holder; }
    public void setHolder(List<EquityHolder> holder) { this.holder = holder; }

    public List<EquitySummary> getSummary() { return summary; }
    public void setSummary(List<EquitySummary> summary) { this.summary = summary; }

    public List<EquityTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<EquityTransaction> transactions) { this.transactions = transactions; }
}

