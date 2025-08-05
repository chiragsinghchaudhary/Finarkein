package com.ashika.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_transaction")
public class DepositTransactionEntity {

    @Id
    private String pan;
    private Double amount;
    private Double currentBalance;
    private String mode;
    private String narration;
    private String reference;
    private String transactionId;
    private Long transactionTimestamp;
    private String type;
    private Long valueDate;

    public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
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

    public Long getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(Long transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getValueDate() {
        return valueDate;
    }

    public void setValueDate(Long valueDate) {
        this.valueDate = valueDate;
    }
}

