package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositTransaction {

     @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("currentBalance")
    private Double currentBalance;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("narration")
    private String narration;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("transactionTimestamp")
    private Long transactionTimestamp;

    @JsonProperty("type")
    private String type;

    @JsonProperty("valueDate")
    private Long valueDate;

    // Getters & Setters


    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Double getCurrentBalance() { return currentBalance; }
    public void setCurrentBalance(Double currentBalance) { this.currentBalance = currentBalance; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public String getNarration() { return narration; }
    public void setNarration(String narration) { this.narration = narration; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public Long getTransactionTimestamp() { return transactionTimestamp; }
    public void setTransactionTimestamp(Long transactionTimestamp) { this.transactionTimestamp = transactionTimestamp; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Long getValueDate() { return valueDate; }
    public void setValueDate(Long valueDate) { this.valueDate = valueDate; }
}
