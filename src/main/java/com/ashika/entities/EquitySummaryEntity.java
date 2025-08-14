package com.ashika.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "equity_summary",indexes = {
	    @Index(name = "idx_equity_summary_pan", columnList = "pan")
	})
public class EquitySummaryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double currentValue;
    private String holdingMode;
    private String isin;
    private String isinDescription;
    private String issuerName;
    private Double lastTradedPrice;
    private Double units;
    private String pan;

    public EquitySummaryEntity(Double currentValue, String holdingMode, String isin, String isinDescription,
                                String issuerName, Double lastTradedPrice, Double units, String pan) {
        this.currentValue = currentValue;
        this.holdingMode = holdingMode;
        this.isin = isin;
        this.isinDescription = isinDescription;
        this.issuerName = issuerName;
        this.lastTradedPrice = lastTradedPrice;
        this.units = units;
        this.pan = pan;
    }

    protected EquitySummaryEntity() {
        // Default constructor for JPA
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public String getHoldingMode() {
        return holdingMode;
    }

    public void setHoldingMode(String holdingMode) {
        this.holdingMode = holdingMode;
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

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public Double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(Double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
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
