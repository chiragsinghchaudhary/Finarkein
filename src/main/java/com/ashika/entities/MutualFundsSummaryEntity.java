package com.ashika.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "mutualfunds_summary",
    indexes = {
        @Index(name = "idx_mutualfunds_summary_pan", columnList = "pan")
    }
)
public class MutualFundsSummaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ucc")
    private String ucc;

    @JsonProperty("maskedDematID")
    private String maskedDematID;

    @JsonProperty("nav")
    private Double nav;

    @JsonProperty("maskedAccNumber")
    private String maskedAccNumber;

    @JsonProperty("isin")
    private String isin;

    @JsonProperty("isinDescription")
    private String isinDescription;

    @JsonProperty("schemeCode")
    private String schemeCode;

    @JsonProperty("folioNo")
    private String folioNo;

    @JsonProperty("account_type")
    private String accountType;

    @JsonProperty("costValue")
    private Double costValue;

    @JsonProperty("closingUnits")
    private String closingUnits; // keep as String for "0.000" formatting

    @JsonProperty("amc")
    private String amc;

    @JsonProperty("registrar")
    private String registrar;

    @JsonProperty("schemeOption")
    private String schemeOption;

    @JsonProperty("schemeCategory")
    private String schemeCategory;

    @JsonProperty("fatcaStatus")
    private String fatcaStatus;

    @JsonProperty("lienUnits")
    private String lienUnits;

    @JsonProperty("lockinUnits")
    private String lockinUnits;

    @JsonProperty("navDate")
    private Long navDate; // Epoch timestamp

    @JsonProperty("linkedAccRef")
    private String linkedAccRef;

    @JsonProperty("currentValue")
    private Double currentValue;

    @JsonProperty("schemeTypes")
    private String schemeTypes;

    @JsonProperty("maskedFolioNo")
    private String maskedFolioNo;

    @JsonProperty("amfiCode")
    private String amfiCode;

    private String pan; // DB search/index only

    private LocalDateTime lastUpdatedTime;


    protected MutualFundsSummaryEntity() {
        // Default constructor for JPA
    }

    public MutualFundsSummaryEntity(String ucc, String maskedDematID, Double nav, String maskedAccNumber,
			String isin, String isinDescription, String schemeCode, String folioNo, String accountType,
			Double costValue, String closingUnits, String amc, String registrar, String schemeOption,
			String schemeCategory, String fatcaStatus, String lienUnits, String lockinUnits, Long navDate,
			String linkedAccRef, Double currentValue, String schemeTypes, String maskedFolioNo, String amfiCode,
			String pan, LocalDateTime lastUpdatedTime) {
		super();
		this.ucc = ucc;
		this.maskedDematID = maskedDematID;
		this.nav = nav;
		this.maskedAccNumber = maskedAccNumber;
		this.isin = isin;
		this.isinDescription = isinDescription;
		this.schemeCode = schemeCode;
		this.folioNo = folioNo;
		this.accountType = accountType;
		this.costValue = costValue;
		this.closingUnits = closingUnits;
		this.amc = amc;
		this.registrar = registrar;
		this.schemeOption = schemeOption;
		this.schemeCategory = schemeCategory;
		this.fatcaStatus = fatcaStatus;
		this.lienUnits = lienUnits;
		this.lockinUnits = lockinUnits;
		this.navDate = navDate;
		this.linkedAccRef = linkedAccRef;
		this.currentValue = currentValue;
		this.schemeTypes = schemeTypes;
		this.maskedFolioNo = maskedFolioNo;
		this.amfiCode = amfiCode;
		this.pan = pan;
		this.lastUpdatedTime = lastUpdatedTime;
	}



	// --- Getters & Setters ---
    public String getUcc() { return ucc; }
    public void setUcc(String ucc) { this.ucc = ucc; }

    public String getMaskedDematID() { return maskedDematID; }
    public void setMaskedDematID(String maskedDematID) { this.maskedDematID = maskedDematID; }

    public Double getNav() { return nav; }
    public void setNav(Double nav) { this.nav = nav; }

    public String getMaskedAccNumber() { return maskedAccNumber; }
    public void setMaskedAccNumber(String maskedAccNumber) { this.maskedAccNumber = maskedAccNumber; }

    public String getIsin() { return isin; }
    public void setIsin(String isin) { this.isin = isin; }

    public String getIsinDescription() { return isinDescription; }
    public void setIsinDescription(String isinDescription) { this.isinDescription = isinDescription; }

    public String getSchemeCode() { return schemeCode; }
    public void setSchemeCode(String schemeCode) { this.schemeCode = schemeCode; }

    public String getFolioNo() { return folioNo; }
    public void setFolioNo(String folioNo) { this.folioNo = folioNo; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public Double getCostValue() { return costValue; }
    public void setCostValue(Double costValue) { this.costValue = costValue; }

    public String getClosingUnits() { return closingUnits; }
    public void setClosingUnits(String closingUnits) { this.closingUnits = closingUnits; }

    public String getAmc() { return amc; }
    public void setAmc(String amc) { this.amc = amc; }

    public String getRegistrar() { return registrar; }
    public void setRegistrar(String registrar) { this.registrar = registrar; }

    public String getSchemeOption() { return schemeOption; }
    public void setSchemeOption(String schemeOption) { this.schemeOption = schemeOption; }

    public String getSchemeCategory() { return schemeCategory; }
    public void setSchemeCategory(String schemeCategory) { this.schemeCategory = schemeCategory; }

    public String getFatcaStatus() { return fatcaStatus; }
    public void setFatcaStatus(String fatcaStatus) { this.fatcaStatus = fatcaStatus; }

    public String getLienUnits() { return lienUnits; }
    public void setLienUnits(String lienUnits) { this.lienUnits = lienUnits; }

    public String getLockinUnits() { return lockinUnits; }
    public void setLockinUnits(String lockinUnits) { this.lockinUnits = lockinUnits; }

    public Long getNavDate() { return navDate; }
    public void setNavDate(Long navDate) { this.navDate = navDate; }

    public String getLinkedAccRef() { return linkedAccRef; }
    public void setLinkedAccRef(String linkedAccRef) { this.linkedAccRef = linkedAccRef; }

    public Double getCurrentValue() { return currentValue; }
    public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }

    public String getSchemeTypes() { return schemeTypes; }
    public void setSchemeTypes(String schemeTypes) { this.schemeTypes = schemeTypes; }

    public String getMaskedFolioNo() { return maskedFolioNo; }
    public void setMaskedFolioNo(String maskedFolioNo) { this.maskedFolioNo = maskedFolioNo; }

    public String getAmfiCode() { return amfiCode; }
    public void setAmfiCode(String amfiCode) { this.amfiCode = amfiCode; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
}
