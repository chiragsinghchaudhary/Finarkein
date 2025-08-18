package com.ashika.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "equities_summary",
    indexes = {
        @Index(name = "idx_equities_summary_pan", columnList = "pan")
    }
)
public class EquitiesSummaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double lastTradedPrice;
    private String maskedAccNumber;
    private String isin;
    private String isinDescription;
    private String accountType;
    private Double units;
    private String linkedAccRef;
    private String type;
    private Double currentValue;
    private String issuerName;
    private String pan; // kept from your original entity
    private LocalDateTime lastUpdatedTime;


    public EquitiesSummaryEntity(
            Double lastTradedPrice,
            String maskedAccNumber,
            String isin,
            String isinDescription,
            String accountType,
            Double units,
            String linkedAccRef,
            String type,
            Double currentValue,
            String issuerName,
            String pan
    ) {
        this.lastTradedPrice = lastTradedPrice;
        this.maskedAccNumber = maskedAccNumber;
        this.isin = isin;
        this.isinDescription = isinDescription;
        this.accountType = accountType;
        this.units = units;
        this.linkedAccRef = linkedAccRef;
        this.type = type;
        this.currentValue = currentValue;
        this.issuerName = issuerName;
        this.pan = pan;
    }

    protected EquitiesSummaryEntity() {
        // Default constructor for JPA
    }

    public Long getId() {
        return id;
    }

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
