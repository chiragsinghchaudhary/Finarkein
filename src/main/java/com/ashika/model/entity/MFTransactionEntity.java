package com.ashika.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mf_transaction")
public class MFTransactionEntity {

	@Id
    private String pan;

    private String startDate;
    private String endDate;
    private String amc;
    private String amfiCode;
    private Double amount;
    private String isin;
    private String isinDescription;
    private Integer lockInDays;
    private String lockInFlag;
    private String mode;
    private String narration;
    private Double nav;
    private String navDate;
    private String registrar;
    private String schemeCode;
    private String schemePlan;
    private Long transactionDate;
    private String txnId;
    private String type;
    private String ucc;
    private Double units;

    // ===== Getters & Setters =====
    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public Integer getLockInDays() {
        return lockInDays;
    }

    public void setLockInDays(Integer lockInDays) {
        this.lockInDays = lockInDays;
    }

    public String getLockInFlag() {
        return lockInFlag;
    }

    public void setLockInFlag(String lockInFlag) {
        this.lockInFlag = lockInFlag;
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

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemePlan() {
        return schemePlan;
    }

    public void setSchemePlan(String schemePlan) {
        this.schemePlan = schemePlan;
    }

    public Long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Long transactionDate) {
        this.transactionDate = transactionDate;
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

    public String getUcc() {
        return ucc;
    }

    public void setUcc(String ucc) {
        this.ucc = ucc;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }
}

