package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquitiesSummary {
	
	@JsonProperty("lastTradedPrice")
    private Double lastTradedPrice;
	
	@JsonProperty("maskedAccNumber")
	private String maskedAccNumber;
	
	@JsonProperty("isin")
    private String isin;
	
	@JsonProperty("isinDescription")
    private String isinDescription;
	
	@JsonProperty("account_type")
    private String accountType;
	
	@JsonProperty("units")
    private Double units;
	
	@JsonProperty("linkedAccRef")
	private String linkedAccRef;
	
	@JsonProperty("type")
    private String type;

    @JsonProperty("currentValue")
    private Double currentValue;

    @JsonProperty("issuerName")
    private String issuerName;

	private String lastUpdatedTime;

	public Double getLastTradedPrice() {
		return lastTradedPrice;
	}

	public void setLastTradedPrice(Double lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}

	public String getMaskedAccNumber() {
		return maskedAccNumber;
	}

	public void setMaskedAccNumber(String maskedAccNumber) {
		this.maskedAccNumber = maskedAccNumber;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getIsinDescription() {
		return isinDescription;
	}

	public void setIsinDescription(String isinDescription) {
		this.isinDescription = isinDescription;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getUnits() {
		return units;
	}

	public void setUnits(Double units) {
		this.units = units;
	}

	public String getLinkedAccRef() {
		return linkedAccRef;
	}

	public void setLinkedAccRef(String linkedAccRef) {
		this.linkedAccRef = linkedAccRef;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	
	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
}

