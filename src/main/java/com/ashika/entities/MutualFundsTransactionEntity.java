package com.ashika.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "mutualfunds_transaction",indexes = {
	    @Index(name = "idx_mutualfunds_transaction_pan", columnList = "pan")
	})
public class MutualFundsTransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String ucc;
	private String txnId;
	private String maskedDematID;
	private Double nav;
	private String maskedAccNumber;
	private String isin;
    private String isinDescription;
    private String schemeCode;
    private String schemePlan;
    private String accountType;
    private Double amount;
    private String amc;
    private String registrar;
    private String narration;
    private Double units;
    private String mode;
    private Integer lockInDays;
    private String navDate;
    private String linkedAccRef;
    private String lockInFlag;
    private Long transactionDate;
    private String type;
    private String maskedFolioNo;
    private String amfiCode;
    
    private String pan;// DB search/index only
    
    private LocalDateTime lastUpdatedTime;
    
	public MutualFundsTransactionEntity(String ucc, String txnId, String maskedDematID, Double nav,
			String maskedAccNumber, String isin, String isinDescription, String schemeCode, String schemePlan,
			String accountType, Double amount, String amc, String registrar, String narration, Double units,
			String mode, Integer lockInDays, String navDate, String linkedAccRef, String lockInFlag,
			Long transactionDate, String type, String maskedFolioNo, String amfiCode, String pan,
			LocalDateTime lastUpdatedTime) {
		super();
		this.ucc = ucc;
		this.txnId = txnId;
		this.maskedDematID = maskedDematID;
		this.nav = nav;
		this.maskedAccNumber = maskedAccNumber;
		this.isin = isin;
		this.isinDescription = isinDescription;
		this.schemeCode = schemeCode;
		this.schemePlan = schemePlan;
		this.accountType = accountType;
		this.amount = amount;
		this.amc = amc;
		this.registrar = registrar;
		this.narration = narration;
		this.units = units;
		this.mode = mode;
		this.lockInDays = lockInDays;
		this.navDate = navDate;
		this.linkedAccRef = linkedAccRef;
		this.lockInFlag = lockInFlag;
		this.transactionDate = transactionDate;
		this.type = type;
		this.maskedFolioNo = maskedFolioNo;
		this.amfiCode = amfiCode;
		this.pan = pan;
		this.lastUpdatedTime = lastUpdatedTime;
	}

	protected MutualFundsTransactionEntity() {
        // Default constructor for JPA
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
