package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositSummary {

    @JsonProperty("balanceDatetime")
    private Long balanceDatetime;

    @JsonProperty("branch")
    private String branch;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("currentBalance")
    private Double currentBalance;

    @JsonProperty("currentODLimit")
    private Double currentODLimit;

    @JsonProperty("drawingLimit")
    private Double drawingLimit;

    @JsonProperty("exchangeRate")
    private String exchangeRate;

    @JsonProperty("facility")
    private String facility;

    @JsonProperty("ifscCode")
    private String ifscCode;

    @JsonProperty("micrCode")
    private String micrCode;

    @JsonProperty("openingDate")
    private String openingDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("type")
    private String type;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("amount")
    private Double amount;

    // Getters & Setters
    public Long getBalanceDatetime() { return balanceDatetime; }
    public void setBalanceDatetime(Long balanceDatetime) { this.balanceDatetime = balanceDatetime; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public Double getCurrentBalance() { return currentBalance; }
    public void setCurrentBalance(Double currentBalance) { this.currentBalance = currentBalance; }

    public Double getCurrentODLimit() { return currentODLimit; }
    public void setCurrentODLimit(Double currentODLimit) { this.currentODLimit = currentODLimit; }

    public Double getDrawingLimit() { return drawingLimit; }
    public void setDrawingLimit(Double drawingLimit) { this.drawingLimit = drawingLimit; }

    public String getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(String exchangeRate) { this.exchangeRate = exchangeRate; }

    public String getFacility() { return facility; }
    public void setFacility(String facility) { this.facility = facility; }

    public String getIfscCode() { return ifscCode; }
    public void setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }

    public String getMicrCode() { return micrCode; }
    public void setMicrCode(String micrCode) { this.micrCode = micrCode; }

    public String getOpeningDate() { return openingDate; }
    public void setOpeningDate(String openingDate) { this.openingDate = openingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}
