package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MFSummary {

    @JsonProperty("costValue")
    private Double costValue;

    @JsonProperty("currentValue")
    private Double currentValue;

    @JsonProperty("FatcaStatus")
    private String fatcaStatus;

    @JsonProperty("amc")
    private String amc;

    @JsonProperty("amfiCode")
    private String amfiCode;

    @JsonProperty("closingUnits")
    private Double closingUnits;

    @JsonProperty("folioNo")
    private String folioNo;

    @JsonProperty("isin")
    private String isin;

    @JsonProperty("isinDescription")
    private String isinDescription;

    @JsonProperty("lienUnits")
    private Double lienUnits;

    @JsonProperty("lockinUnits")
    private Double lockinUnits;

    @JsonProperty("nav")
    private Double nav;

    @JsonProperty("navDate")
    private String navDate;

    @JsonProperty("registrar")
    private String registrar;

    @JsonProperty("schemeCategory")
    private String schemeCategory;

    @JsonProperty("schemeCode")
    private String schemeCode;

    @JsonProperty("schemeOption")
    private String schemeOption;

    @JsonProperty("schemeTypes")
    private String schemeTypes;

    @JsonProperty("ucc")
    private String ucc;

    // Getters & Setters
    public Double getCostValue() { return costValue; }
    public void setCostValue(Double costValue) { this.costValue = costValue; }

    public Double getCurrentValue() { return currentValue; }
    public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }

    public String getFatcaStatus() { return fatcaStatus; }
    public void setFatcaStatus(String fatcaStatus) { this.fatcaStatus = fatcaStatus; }

    public String getAmc() { return amc; }
    public void setAmc(String amc) { this.amc = amc; }

    public String getAmfiCode() { return amfiCode; }
    public void setAmfiCode(String amfiCode) { this.amfiCode = amfiCode; }

    public Double getClosingUnits() { return closingUnits; }
    public void setClosingUnits(Double closingUnits) { this.closingUnits = closingUnits; }

    public String getFolioNo() { return folioNo; }
    public void setFolioNo(String folioNo) { this.folioNo = folioNo; }

    public String getIsin() { return isin; }
    public void setIsin(String isin) { this.isin = isin; }

    public String getIsinDescription() { return isinDescription; }
    public void setIsinDescription(String isinDescription) { this.isinDescription = isinDescription; }

    public Double getLienUnits() { return lienUnits; }
    public void setLienUnits(Double lienUnits) { this.lienUnits = lienUnits; }

    public Double getLockinUnits() { return lockinUnits; }
    public void setLockinUnits(Double lockinUnits) { this.lockinUnits = lockinUnits; }

    public Double getNav() { return nav; }
    public void setNav(Double nav) { this.nav = nav; }

    public String getNavDate() { return navDate; }
    public void setNavDate(String navDate) { this.navDate = navDate; }

    public String getRegistrar() { return registrar; }
    public void setRegistrar(String registrar) { this.registrar = registrar; }

    public String getSchemeCategory() { return schemeCategory; }
    public void setSchemeCategory(String schemeCategory) { this.schemeCategory = schemeCategory; }

    public String getSchemeCode() { return schemeCode; }
    public void setSchemeCode(String schemeCode) { this.schemeCode = schemeCode; }

    public String getSchemeOption() { return schemeOption; }
    public void setSchemeOption(String schemeOption) { this.schemeOption = schemeOption; }

    public String getSchemeTypes() { return schemeTypes; }
    public void setSchemeTypes(String schemeTypes) { this.schemeTypes = schemeTypes; }

    public String getUcc() { return ucc; }
    public void setUcc(String ucc) { this.ucc = ucc; }
}

