package com.ashika.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_summary", indexes = { @Index(name = "idx_deposit_summary_pan", columnList = "pan") })
public class DepositSummaryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long currentODLimit;
	private String openingDate;
	private String fipName;
	private String maskedAccNumber;

	private String branch;
	private String accountType;
	private Double currentBalance;
	private Double drawingLimit;
	private Long accountAgeInDays;
	private String pendingTransactionType;
	private String status;
	private String micrCode;
	private Long balanceDatetime;
	private String currency;
	private Double pendingAmount;
	private String linkedAccRef;
	private String ifscCode;
	private String type;
	private String facility;
	private String exchangeRate;
	private String pan;
	private LocalDateTime lastUpdatedTime;

	

	public DepositSummaryEntity(Long id, Long currentODLimit, String openingDate, String fipName,
			String maskedAccNumber, String branch, String accountType, Double currentBalance, Double drawingLimit,
			Long accountAgeInDays, String pendingTransactionType, String status, String micrCode, Long balanceDatetime,
			String currency, Double pendingAmount, String linkedAccRef, String ifscCode, String type, String facility,
			String exchangeRate, String pan, LocalDateTime lastUpdatedTime) {
		super();
		this.id = id;
		this.currentODLimit = currentODLimit;
		this.openingDate = openingDate;
		this.fipName = fipName;
		this.maskedAccNumber = maskedAccNumber;
		this.branch = branch;
		this.accountType = accountType;
		this.currentBalance = currentBalance;
		this.drawingLimit = drawingLimit;
		this.accountAgeInDays = accountAgeInDays;
		this.pendingTransactionType = pendingTransactionType;
		this.status = status;
		this.micrCode = micrCode;
		this.balanceDatetime = balanceDatetime;
		this.currency = currency;
		this.pendingAmount = pendingAmount;
		this.linkedAccRef = linkedAccRef;
		this.ifscCode = ifscCode;
		this.type = type;
		this.facility = facility;
		this.exchangeRate = exchangeRate;
		this.pan = pan;
		this.lastUpdatedTime = lastUpdatedTime;
	}

	protected DepositSummaryEntity() {
		// Default constructor for JPA
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(Double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public String getLinkedAccRef() {
		return linkedAccRef;
	}

	public void setLinkedAccRef(String linkedAccRef) {
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

}
