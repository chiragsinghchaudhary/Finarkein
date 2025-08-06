package com.ashika.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_summary")
public class DepositSummaryEntity {

	@Id
	private String pan;
	private Long balanceDatetime;
	private String branch;
	private String currency;
	private Double currentBalance;
	private Double currentODLimit;
	private Double drawingLimit;
	private String exchangeRate;
	private String facility;
	private String ifscCode;
	private String micrCode;
	private String openingDate;
	private String status;
	private String type;
	private String transactionType;
	private Double amount;

	public DepositSummaryEntity(String pan, Long balanceDatetime, String branch, String currency, Double currentBalance,
			Double currentODLimit, Double drawingLimit, String exchangeRate, String facility, String ifscCode,
			String micrCode, String openingDate, String status, String type, String transactionType, Double amount) {
		this.pan = pan;
		this.balanceDatetime = balanceDatetime;
		this.branch = branch;
		this.currency = currency;
		this.currentBalance = currentBalance;
		this.currentODLimit = currentODLimit;
		this.drawingLimit = drawingLimit;
		this.exchangeRate = exchangeRate;
		this.facility = facility;
		this.ifscCode = ifscCode;
		this.micrCode = micrCode;
		this.openingDate = openingDate;
		this.status = status;
		this.type = type;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	protected DepositSummaryEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Long getBalanceDatetime() {
		return balanceDatetime;
	}

	public void setBalanceDatetime(Long balanceDatetime) {
		this.balanceDatetime = balanceDatetime;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getCurrentODLimit() {
		return currentODLimit;
	}

	public void setCurrentODLimit(Double currentODLimit) {
		this.currentODLimit = currentODLimit;
	}

	public Double getDrawingLimit() {
		return drawingLimit;
	}

	public void setDrawingLimit(Double drawingLimit) {
		this.drawingLimit = drawingLimit;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getMicrCode() {
		return micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
