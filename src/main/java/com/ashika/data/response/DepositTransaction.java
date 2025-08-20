package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositTransaction {

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("txnId")
	private String txnId;

	@JsonProperty("maskedAccNumber")
	private String maskedAccNumber;

	@JsonProperty("transactionTimestamp")
	private Long transactionTimestamp;

	@JsonProperty("account_type")
	private String accountType;

	@JsonProperty("currentBalance")
	private Double currentBalance;

	@JsonProperty("amount")
	private Double amount;

	@JsonProperty("valueDate")
	private Long valueDate;

	@JsonProperty("narration")
	private String narration;

	@JsonProperty("mode")
	private String mode;

	@JsonProperty("linkedAccRef")
	private String linkedAccRef;

	@JsonProperty("type")
	private String type;

	private String lastUpdatedTime;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getMaskedAccNumber() {
		return maskedAccNumber;
	}

	public void setMaskedAccNumber(String maskedAccNumber) {
		this.maskedAccNumber = maskedAccNumber;
	}

	public Long getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public void setTransactionTimestamp(Long transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getValueDate() {
		return valueDate;
	}

	public void setValueDate(Long valueDate) {
		this.valueDate = valueDate;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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
	
	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
}
