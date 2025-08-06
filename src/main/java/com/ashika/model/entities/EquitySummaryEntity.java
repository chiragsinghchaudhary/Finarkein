package com.ashika.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equity_summary")
public class EquitySummaryEntity {

	@Id
	private String pan;
	private Double currentValue;
	private String holdingMode;
	private String isin;
	private String isinDescription;
	private String issuerName;
	private Double lastTradedPrice;
	private Double units;

	public EquitySummaryEntity(String pan, Double currentValue, String holdingMode, String isin, String isinDescription,
			String issuerName, Double lastTradedPrice, Double units) {
		super();
		this.pan = pan;
		this.currentValue = currentValue;
		this.holdingMode = holdingMode;
		this.isin = isin;
		this.isinDescription = isinDescription;
		this.issuerName = issuerName;
		this.lastTradedPrice = lastTradedPrice;
		this.units = units;
	}

	protected EquitySummaryEntity() {
		// TODO Auto-generated constructor stub
	}

	// ===== Getters & Setters =====
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
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
}
