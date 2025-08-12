package com.ashika.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equity_transaction")
public class EquityTransactionEntity {

    private String companyName;
    private String equityCategory;
    private String exchange;
    private String isin;
    private String isinDescription;
    private String narration;
    private String orderId;
    private Double rate;
    private Long transactionDateTime;
    private String txnId;
    private String type;
    private Double units;

    @Id
    private String pan;

    public EquityTransactionEntity(String companyName, String equityCategory, String exchange, String isin,
                                   String isinDescription, String narration, String orderId, Double rate,
                                   Long transactionDateTime, String txnId, String type, Double units, String pan) {
        this.companyName = companyName;
        this.equityCategory = equityCategory;
        this.exchange = exchange;
        this.isin = isin;
        this.isinDescription = isinDescription;
        this.narration = narration;
        this.orderId = orderId;
        this.rate = rate;
        this.transactionDateTime = transactionDateTime;
        this.txnId = txnId;
        this.type = type;
        this.units = units;
        this.pan = pan;
    }

    protected EquityTransactionEntity() {
        // Default constructor for JPA
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Long transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
