package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquityTransaction {

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("equityCategory")
    private String equityCategory;

    @JsonProperty("exchange")
    private String exchange;

    @JsonProperty("isin")
    private String isin;

    @JsonProperty("isinDescription")
    private String isinDescription;

    @JsonProperty("narration")
    private String narration;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("rate")
    private Double rate;

    @JsonProperty("transactionDateTime")
    private Long transactionDateTime;

    @JsonProperty("txnId")
    private String txnId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("units")
    private Double units;

    // Getters & Setters
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getEquityCategory() { return equityCategory; }
    public void setEquityCategory(String equityCategory) { this.equityCategory = equityCategory; }

    public String getExchange() { return exchange; }
    public void setExchange(String exchange) { this.exchange = exchange; }

    public String getIsin() { return isin; }
    public void setIsin(String isin) { this.isin = isin; }

    public String getIsinDescription() { return isinDescription; }
    public void setIsinDescription(String isinDescription) { this.isinDescription = isinDescription; }

    public String getNarration() { return narration; }
    public void setNarration(String narration) { this.narration = narration; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public Double getRate() { return rate; }
    public void setRate(Double rate) { this.rate = rate; }

    public Long getTransactionDateTime() { return transactionDateTime; }
    public void setTransactionDateTime(Long transactionDateTime) { this.transactionDateTime = transactionDateTime; }

    public String getTxnId() { return txnId; }
    public void setTxnId(String txnId) { this.txnId = txnId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getUnits() { return units; }
    public void setUnits(Double units) { this.units = units; }
}

