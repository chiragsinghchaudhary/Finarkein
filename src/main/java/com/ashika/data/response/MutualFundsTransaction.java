package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MutualFundsTransaction {
	
	@JsonProperty("ucc")
    private String ucc;
	
	@JsonProperty("txnId")
    private String txnId;
	
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

    @JsonProperty("schemePlan")
    private String schemePlan;
    
    @JsonProperty("account_type")
    private String accountType;
    
    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("amc")
    private String amc;
    
    @JsonProperty("registrar")
    private String registrar;
    
    @JsonProperty("narration")
    private String narration;
    
    @JsonProperty("units")
    private Double units;
    
    @JsonProperty("mode")
    private String mode;
    
    @JsonProperty("lock-inDays")
    private Integer lockInDays;
    
    @JsonProperty("navDate")
    private String navDate;
    
    @JsonProperty("linkedAccRef")
	private String linkedAccRef;
    
    @JsonProperty("lock-inFlag")
    private String lockInFlag;
    
    @JsonProperty("transactionDate")
    private Long transactionDate;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("maskedFolioNo")
	private String maskedFolioNo;

    @JsonProperty("amfiCode")
    private String amfiCode;

	public String getUcc() {
		return ucc;
	}

	public void setUcc(String ucc) {
		this.ucc = ucc;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getMaskedDematID() {
		return maskedDematID;
	}

	public void setMaskedDematID(String maskedDematID) {
		this.maskedDematID = maskedDematID;
	}

	public Double getNav() {
		return nav;
	}

	public void setNav(Double nav) {
		this.nav = nav;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAmc() {
		return amc;
	}

	public void setAmc(String amc) {
		this.amc = amc;
	}

	public String getRegistrar() {
		return registrar;
	}

	public void setRegistrar(String registrar) {
		this.registrar = registrar;
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Integer getLockInDays() {
		return lockInDays;
	}

	public void setLockInDays(Integer lockInDays) {
		this.lockInDays = lockInDays;
	}

	public String getNavDate() {
		return navDate;
	}

	public void setNavDate(String navDate) {
		this.navDate = navDate;
	}

	public String getLinkedAccRef() {
		return linkedAccRef;
	}

	public void setLinkedAccRef(String linkedAccRef) {
		this.linkedAccRef = linkedAccRef;
	}

	public String getLockInFlag() {
		return lockInFlag;
	}

	public void setLockInFlag(String lockInFlag) {
		this.lockInFlag = lockInFlag;
	}

	public Long getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Long transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMaskedFolioNo() {
		return maskedFolioNo;
	}

	public void setMaskedFolioNo(String maskedFolioNo) {
		this.maskedFolioNo = maskedFolioNo;
	}

	public String getAmfiCode() {
		return amfiCode;
	}

	public void setAmfiCode(String amfiCode) {
		this.amfiCode = amfiCode;
	}
}

