package com.ashika.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_transaction",indexes = {
	    @Index(name = "idx_deposit_transaction_pan", columnList = "pan")
	})
public class DepositTransactionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pan;
    private String reference;
    private String transactionId;
    private String maskedAccNumber;
    private Long transactionTimestamp;
    private String accountType;
    private Double currentBalance;
    private Double amount;
    private Long valueDate;
    private String narration;
    private String mode;
    private String linkedAccRef;
    private String type;
    private LocalDateTime lastUpdatedTime;

    public DepositTransactionEntity(String pan, String reference, String transactionId, String maskedAccNumber,
			Long transactionTimestamp, String accountType, Double currentBalance, Double amount, Long valueDate,
			String narration, String mode, String linkedAccRef, String type, LocalDateTime lastUpdatedTime) {
		super();
		this.pan = pan;
		this.reference = reference;
		this.transactionId = transactionId;
		this.maskedAccNumber = maskedAccNumber;
		this.transactionTimestamp = transactionTimestamp;
		this.accountType = accountType;
		this.currentBalance = currentBalance;
		this.amount = amount;
		this.valueDate = valueDate;
		this.narration = narration;
		this.mode = mode;
		this.linkedAccRef = linkedAccRef;
		this.type = type;
		this.lastUpdatedTime = lastUpdatedTime;
	}

	protected DepositTransactionEntity() {
        // Default constructor for JPA
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
	public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
}
