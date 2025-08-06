package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MFResponse {

    @JsonProperty("holder")
    private List<MFHolder> holder;

    @JsonProperty("summary")
    private List<MFSummary> summary;

    @JsonProperty("transactions")
    private List<MFTransaction> transactions;

    // ===== Main Getters & Setters =====
    public List<MFHolder> getHolder() { return holder; }
    public void setHolder(List<MFHolder> holder) { this.holder = holder; }

    public List<MFSummary> getSummary() { return summary; }
    public void setSummary(List<MFSummary> summary) { this.summary = summary; }

    public List<MFTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<MFTransaction> transactions) { this.transactions = transactions; }
}
