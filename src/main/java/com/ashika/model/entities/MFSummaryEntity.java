package com.ashika.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mf_summary")
public class MFSummaryEntity {

    private Double costValue;
    private Double currentValue;
    private String fatcaStatus;
    private String amc;
    private String amfiCode;
    private Double closingUnits;
    private String folioNo;
    private String isin;
    private String isinDescription;
    private Double lienUnits;
    private Double lockinUnits;
    private Double nav;
    private String navDate;
    private String registrar;
    private String schemeCategory;
    private String schemeCode;
    private String schemeOption;
    private String schemeTypes;
    private String ucc;

    @Id
    private String pan;

    public MFSummaryEntity(Double costValue, Double currentValue, String fatcaStatus, String amc,
                           String amfiCode, Double closingUnits, String folioNo, String isin,
                           String isinDescription, Double lienUnits, Double lockinUnits, Double nav,
                           String navDate, String registrar, String schemeCategory, String schemeCode,
                           String schemeOption, String schemeTypes, String ucc, String pan) {
        this.costValue = costValue;
        this.currentValue = currentValue;
        this.fatcaStatus = fatcaStatus;
        this.amc = amc;
        this.amfiCode = amfiCode;
        this.closingUnits = closingUnits;
        this.folioNo = folioNo;
        this.isin = isin;
        this.isinDescription = isinDescription;
        this.lienUnits = lienUnits;
        this.lockinUnits = lockinUnits;
        this.nav = nav;
        this.navDate = navDate;
        this.registrar = registrar;
        this.schemeCategory = schemeCategory;
        this.schemeCode = schemeCode;
        this.schemeOption = schemeOption;
        this.schemeTypes = schemeTypes;
        this.ucc = ucc;
        this.pan = pan;
    }

    protected MFSummaryEntity() {
        // Default constructor for JPA
    }

    public Double getCostValue() {
        return costValue;
    }

    public void setCostValue(Double costValue) {
        this.costValue = costValue;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public String getFatcaStatus() {
        return fatcaStatus;
    }

    public void setFatcaStatus(String fatcaStatus) {
        this.fatcaStatus = fatcaStatus;
    }

    public String getAmc() {
        return amc;
    }

    public void setAmc(String amc) {
        this.amc = amc;
    }

    public String getAmfiCode() {
        return amfiCode;
    }

    public void setAmfiCode(String amfiCode) {
        this.amfiCode = amfiCode;
    }

    public Double getClosingUnits() {
        return closingUnits;
    }

    public void setClosingUnits(Double closingUnits) {
        this.closingUnits = closingUnits;
    }

    public String getFolioNo() {
        return folioNo;
    }

    public void setFolioNo(String folioNo) {
        this.folioNo = folioNo;
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

    public Double getLienUnits() {
        return lienUnits;
    }

    public void setLienUnits(Double lienUnits) {
        this.lienUnits = lienUnits;
    }

    public Double getLockinUnits() {
        return lockinUnits;
    }

    public void setLockinUnits(Double lockinUnits) {
        this.lockinUnits = lockinUnits;
    }

    public Double getNav() {
        return nav;
    }

    public void setNav(Double nav) {
        this.nav = nav;
    }

    public String getNavDate() {
        return navDate;
    }

    public void setNavDate(String navDate) {
        this.navDate = navDate;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    public String getSchemeCategory() {
        return schemeCategory;
    }

    public void setSchemeCategory(String schemeCategory) {
        this.schemeCategory = schemeCategory;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemeOption() {
        return schemeOption;
    }

    public void setSchemeOption(String schemeOption) {
        this.schemeOption = schemeOption;
    }

    public String getSchemeTypes() {
        return schemeTypes;
    }

    public void setSchemeTypes(String schemeTypes) {
        this.schemeTypes = schemeTypes;
    }

    public String getUcc() {
        return ucc;
    }

    public void setUcc(String ucc) {
        this.ucc = ucc;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
