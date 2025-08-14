package com.ashika.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "equity_transaction",
    indexes = {
        @Index(name = "idx_equity_transaction_pan", columnList = "pan")
    }
)
public class EquityTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rate;
    private String txnId;
    private Long transactionDateTime;
    private String orderId;
    private String isin;
    private String isinDescription;
    private String equityCategory;
    private String exchange;
    private String companyName;
    private String narration;
    private Double units;
    private String type;
    private String pan;

    public EquityTransactionEntity(Double rate, String txnId, Long transactionDateTime, String orderId,
                                   String isin, String isinDescription, String equityCategory, String exchange,
                                   String companyName, String narration, Double units, String type, String pan) {
        this.rate = rate;
        this.txnId = txnId;
        this.transactionDateTime = transactionDateTime;
        this.orderId = orderId;
        this.isin = isin;
        this.isinDescription = isinDescription;
        this.equityCategory = equityCategory;
        this.exchange = exchange;
        this.companyName = companyName;
        this.narration = narration;
        this.units = units;
        this.type = type;
        this.pan = pan;
    }

    protected EquityTransactionEntity() {
        // Default constructor for JPA
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
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

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
