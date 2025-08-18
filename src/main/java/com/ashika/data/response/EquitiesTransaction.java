package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquitiesTransaction {
	
	@JsonProperty("rate")
    private String rate;
	
	@JsonProperty("txnId")
    private String txnId;
	
	@JsonProperty("transactionDateTime")
    private Long transactionDateTime;
	
	@JsonProperty("orderId")
    private String orderId;
	
	@JsonProperty("maskedAccNumber")
	private String maskedAccNumber;
	
	@JsonProperty("isin")
    private String isin;

    @JsonProperty("isinDescription")
    private String isinDescription;
    
    @JsonProperty("account_type")
    private String accountType;
    
    @JsonProperty("equityCategory")
    private String equityCategory;
    
    @JsonProperty("exchange")
    private String exchange;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("narration")
    private String narration;

    @JsonProperty("units")
    private Long units;

    @JsonProperty("linkedAccRef")
	private String linkedAccRef;

    @JsonProperty("type")
    private String type;

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public Long getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Long transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getEquityCategory() {
		return equityCategory;
	}

	public void setEquityCategory(String equityCategory) {
		this.equityCategory = equityCategory;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Long getUnits() {
		return units;
	}

	public void setUnits(Long units) {
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
    
}

