package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MFTransaction {

    @JsonProperty("amc")
    private String amc;

    @JsonProperty("amfiCode")
    private String amfiCode;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("isin")
    private String isin;

    @JsonProperty("isinDescription")
    private String isinDescription;

    @JsonProperty("lock-inDays")
    private Integer lockInDays;

    @JsonProperty("lock-inFlag")
    private String lockInFlag;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("narration")
    private String narration;

    @JsonProperty("nav")
    private Double nav;

    @JsonProperty("navDate")
    private String navDate;

    @JsonProperty("registrar")
    private String registrar;

    @JsonProperty("schemeCode")
    private String schemeCode;

    @JsonProperty("schemePlan")
    private String schemePlan;

    @JsonProperty("transactionDate")
    private Long transactionDate;

    @JsonProperty("txnId")
    private String txnId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("ucc")
    private String ucc;

    @JsonProperty("units")
    private Double units;

    // Getters & Setters
    public String getAmc() { return amc; }
    public void setAmc(String amc) { this.amc = amc; }

    public String getAmfiCode() { return amfiCode; }
    public void setAmfiCode(String amfiCode) { this.amfiCode = amfiCode; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getIsin() { return isin; }
    public void setIsin(String isin) { this.isin = isin; }

    public String getIsinDescription() { return isinDescription; }
    public void setIsinDescription(String isinDescription) { this.isinDescription = isinDescription; }

    public Integer getLockInDays() { return lockInDays; }
    public void setLockInDays(Integer lockInDays) { this.lockInDays = lockInDays; }

    public String getLockInFlag() { return lockInFlag; }
    public void setLockInFlag(String lockInFlag) { this.lockInFlag = lockInFlag; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public String getNarration() { return narration; }
    public void setNarration(String narration) { this.narration = narration; }

    public Double getNav() { return nav; }
    public void setNav(Double nav) { this.nav = nav; }

    public String getNavDate() { return navDate; }
    public void setNavDate(String navDate) { this.navDate = navDate; }

    public String getRegistrar() { return registrar; }
    public void setRegistrar(String registrar) { this.registrar = registrar; }

    public String getSchemeCode() { return schemeCode; }
    public void setSchemeCode(String schemeCode) { this.schemeCode = schemeCode; }

    public String getSchemePlan() { return schemePlan; }
    public void setSchemePlan(String schemePlan) { this.schemePlan = schemePlan; }

    public Long getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Long transactionDate) { this.transactionDate = transactionDate; }

    public String getTxnId() { return txnId; }
    public void setTxnId(String txnId) { this.txnId = txnId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUcc() { return ucc; }
    public void setUcc(String ucc) { this.ucc = ucc; }

    public Double getUnits() { return units; }
    public void setUnits(Double units) { this.units = units; }
}

