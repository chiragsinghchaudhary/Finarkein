package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Full response for Mutual Fund data containing profile, summary, and transactions.
 */
public class MFResponse {

    @JsonProperty("profile")
    private List<Profile> profile;

    @JsonProperty("summary")
    private List<Summary> summary;

    @JsonProperty("transactions")
    private List<Transaction> transactions; 

    // ================== Profile ==================
    public static class Profile {
        @JsonProperty("address")
        private String address;

        @JsonProperty("dematId")
        private String dematId;

        @JsonProperty("dob")
        private Long dob;

        @JsonProperty("email")
        private String email;

        @JsonProperty("folioNo")
        private String folioNo;

        @JsonProperty("kycCompliance")
        private Boolean kycCompliance;

        @JsonProperty("landline")
        private String landline;

        @JsonProperty("mobile")
        private String mobile;

        @JsonProperty("name")
        private String name;

        @JsonProperty("nominee")
        private String nominee;

        @JsonProperty("pan")
        private String pan;

        // Getters and Setters
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public String getDematId() { return dematId; }
        public void setDematId(String dematId) { this.dematId = dematId; }

        public Long getDob() { return dob; }
        public void setDob(Long dob) { this.dob = dob; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getFolioNo() { return folioNo; }
        public void setFolioNo(String folioNo) { this.folioNo = folioNo; }

        public Boolean getKycCompliance() { return kycCompliance; }
        public void setKycCompliance(Boolean kycCompliance) { this.kycCompliance = kycCompliance; }

        public String getLandline() { return landline; }
        public void setLandline(String landline) { this.landline = landline; }

        public String getMobile() { return mobile; }
        public void setMobile(String mobile) { this.mobile = mobile; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getNominee() { return nominee; }
        public void setNominee(String nominee) { this.nominee = nominee; }

        public String getPan() { return pan; }
        public void setPan(String pan) { this.pan = pan; }
    }

    // ================== Summary ==================
    public static class Summary {
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

        // Getters and Setters
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

    // ================== Transactions (Flattened) ==================
    public static class Transaction {
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
        private String transactionDate;

        @JsonProperty("txnId")
        private String txnId;

        @JsonProperty("type")
        private String type;

        @JsonProperty("ucc")
        private String ucc;

        @JsonProperty("units")
        private Double units;

        // Getters and Setters
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

        public String getTransactionDate() { return transactionDate; }
        public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }

        public String getTxnId() { return txnId; }
        public void setTxnId(String txnId) { this.txnId = txnId; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getUcc() { return ucc; }
        public void setUcc(String ucc) { this.ucc = ucc; }

        public Double getUnits() { return units; }
        public void setUnits(Double units) { this.units = units; }
    }

    // ===== Main Getters & Setters =====
    public List<Profile> getProfile() { return profile; }
    public void setProfile(List<Profile> profile) { this.profile = profile; }

    public List<Summary> getSummary() { return summary; }
    public void setSummary(List<Summary> summary) { this.summary = summary; }

    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }
}
