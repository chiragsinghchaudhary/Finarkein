package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositSummary {
	
	@JsonProperty("currentODLimit")
    private Long currentODLimit;
	
	@JsonProperty("openingDate")
    private String openingDate;
	
	@JsonProperty("fipName")
    private String fipName;
	
    @JsonProperty("maskedAccNumber")
	private String maskedAccNumber;

	@JsonProperty("branch")
	private String branch;
	
	@JsonProperty("account_type")
	private String accountType;
	
	@JsonProperty("currentBalance")
    private Double currentBalance;

    @JsonProperty("drawingLimit")
    private Double drawingLimit;
    
    @JsonProperty("accountAgeInDays")
    private Long accountAgeInDays;

    @JsonProperty("pending_transactionType")
    private String pendingTransactionType;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("micrCode")
    private String micrCode;

    @JsonProperty("balanceDatetime")
    private Long balanceDatetime;

    @JsonProperty("currency")
    private String currency;
    
    @JsonProperty("pending_amount")
    private Double pending_amount;
    
    @JsonProperty("linkedAccRef")
	private Boolean linkedAccRef;
    
    @JsonProperty("ifscCode")
    private String ifscCode;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("facility")
    private String facility;

    @JsonProperty("exchangeRate")
    private String exchangeRate;

	public Long getCurrentODLimit() {
		return currentODLimit;
	}

	public void setCurrentODLimit(Long currentODLimit) {
		this.currentODLimit = currentODLimit;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getFipName() {
		return fipName;
	}

	public void setFipName(String fipName) {
		this.fipName = fipName;
	}

	public String getMaskedAccNumber() {
		return maskedAccNumber;
	}

	public void setMaskedAccNumber(String maskedAccNumber) {
		this.maskedAccNumber = maskedAccNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getDrawingLimit() {
		return drawingLimit;
	}

	public void setDrawingLimit(Double drawingLimit) {
		this.drawingLimit = drawingLimit;
	}

	public Long getAccountAgeInDays() {
		return accountAgeInDays;
	}

	public void setAccountAgeInDays(Long accountAgeInDays) {
		this.accountAgeInDays = accountAgeInDays;
	}

	public String getPendingTransactionType() {
		return pendingTransactionType;
	}

	public void setPendingTransactionType(String pendingTransactionType) {
		this.pendingTransactionType = pendingTransactionType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMicrCode() {
		return micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	public Long getBalanceDatetime() {
		return balanceDatetime;
	}

	public void setBalanceDatetime(Long balanceDatetime) {
		this.balanceDatetime = balanceDatetime;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getPending_amount() {
		return pending_amount;
	}

	public void setPending_amount(Double pending_amount) {
		this.pending_amount = pending_amount;
	}

	public Boolean getLinkedAccRef() {
		return linkedAccRef;
	}

	public void setLinkedAccRef(Boolean linkedAccRef) {
		this.linkedAccRef = linkedAccRef;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
