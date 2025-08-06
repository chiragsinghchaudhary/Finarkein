package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquitySummary {

    @JsonProperty("currentValue")
    private Double currentValue;

    @JsonProperty("holdingMode")
    private String holdingMode;

    @JsonProperty("isin")
    private String isin;

    @JsonProperty("isinDescription")
    private String isinDescription;

    @JsonProperty("issuerName")
    private String issuerName;

    @JsonProperty("lastTradedPrice")
    private Double lastTradedPrice;

    @JsonProperty("units")
    private Double units;

    // Getters & Setters
    public Double getCurrentValue() { return currentValue; }
    public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }

    public String getHoldingMode() { return holdingMode; }
    public void setHoldingMode(String holdingMode) { this.holdingMode = holdingMode; }

    public String getIsin() { return isin; }
    public void setIsin(String isin) { this.isin = isin; }

    public String getIsinDescription() { return isinDescription; }
    public void setIsinDescription(String isinDescription) { this.isinDescription = isinDescription; }

    public String getIssuerName() { return issuerName; }
    public void setIssuerName(String issuerName) { this.issuerName = issuerName; }

    public Double getLastTradedPrice() { return lastTradedPrice; }
    public void setLastTradedPrice(Double lastTradedPrice) { this.lastTradedPrice = lastTradedPrice; }

    public Double getUnits() { return units; }
    public void setUnits(Double units) { this.units = units; }
}

