package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Full response for Equity data containing profile, summary, and transactions.
 */
public class EquityResponse {

    @JsonProperty("profile")
    private Profile profile;

    @JsonProperty("summary")
    private List<Summary> summary;

    @JsonProperty("transactions")
    private Transactions transactions;

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

        // Getters & Setters
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public String getDematId() { return dematId; }
        public void setDematId(String dematId) { this.dematId = dematId; }

        public Long getDob() { return dob; }
        public void setDob(Long dob) { this.dob = dob; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

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

    // ================== Summary (Equity Holdings) ==================
    public static class Summary {
        @JsonProperty("currentValue")
        private Double currentValue;

        @JsonProperty("holdingMode")
        private String holdingMode;

        @JsonProperty("isin")
        private String isin;

        @JsonProperty("isinDescription")
        private String isinDescription;

        @JsonProperty("issuerName")
        private String issuerName;

        @JsonProperty("lastTradedPrice")
        private Double lastTradedPrice;

        @JsonProperty("units")
        private Double units;

        // Getters & Setters
        public Double getCurrentValue() { return currentValue; }
        public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }

        public String getHoldingMode() { return holdingMode; }
        public void setHoldingMode(String holdingMode) { this.holdingMode = holdingMode; }

        public String getIsin() { return isin; }
        public void setIsin(String isin) { this.isin = isin; }

        public String getIsinDescription() { return isinDescription; }
        public void setIsinDescription(String isinDescription) { this.isinDescription = isinDescription; }

        public String getIssuerName() { return issuerName; }
        public void setIssuerName(String issuerName) { this.issuerName = issuerName; }

        public Double getLastTradedPrice() { return lastTradedPrice; }
        public void setLastTradedPrice(Double lastTradedPrice) { this.lastTradedPrice = lastTradedPrice; }

        public Double getUnits() { return units; }
        public void setUnits(Double units) { this.units = units; }
    }

    // ================== Transactions ==================
    public static class Transactions {
        @JsonProperty("startDate")
        private String startDate;

        @JsonProperty("endDate")
        private String endDate;

        @JsonProperty("transaction")
        private List<Transaction> transactionList;

        // Meta Getters & Setters
        public String getStartDate() { return startDate; }
        public void setStartDate(String startDate) { this.startDate = startDate; }

        public String getEndDate() { return endDate; }
        public void setEndDate(String endDate) { this.endDate = endDate; }

        public List<Transaction> getTransactionList() { return transactionList; }
        public void setTransactionList(List<Transaction> transactionList) { this.transactionList = transactionList; }

        // Individual transaction
        public static class Transaction {
            @JsonProperty("companyName")
            private String companyName;

            @JsonProperty("equityCategory")
            private String equityCategory;

            @JsonProperty("exchange")
            private String exchange;

            @JsonProperty("isin")
            private String isin;

            @JsonProperty("isinDescription")
            private String isinDescription;

            @JsonProperty("narration")
            private String narration;

            @JsonProperty("orderId")
            private String orderId;

            @JsonProperty("rate")
            private Double rate;

            @JsonProperty("transactionDateTime")
            private Long transactionDateTime;

            @JsonProperty("txnId")
            private String txnId;

            @JsonProperty("type")
            private String type;

            @JsonProperty("units")
            private Double units;

            // Getters & Setters
            public String getCompanyName() { return companyName; }
            public void setCompanyName(String companyName) { this.companyName = companyName; }

            public String getEquityCategory() { return equityCategory; }
            public void setEquityCategory(String equityCategory) { this.equityCategory = equityCategory; }

            public String getExchange() { return exchange; }
            public void setExchange(String exchange) { this.exchange = exchange; }

            public String getIsin() { return isin; }
            public void setIsin(String isin) { this.isin = isin; }

            public String getIsinDescription() { return isinDescription; }
            public void setIsinDescription(String isinDescription) { this.isinDescription = isinDescription; }

            public String getNarration() { return narration; }
            public void setNarration(String narration) { this.narration = narration; }

            public String getOrderId() { return orderId; }
            public void setOrderId(String orderId) { this.orderId = orderId; }

            public Double getRate() { return rate; }
            public void setRate(Double rate) { this.rate = rate; }

            public Long getTransactionDateTime() { return transactionDateTime; }
            public void setTransactionDateTime(Long transactionDateTime) { this.transactionDateTime = transactionDateTime; }

            public String getTxnId() { return txnId; }
            public void setTxnId(String txnId) { this.txnId = txnId; }

            public String getType() { return type; }
            public void setType(String type) { this.type = type; }

            public Double getUnits() { return units; }
            public void setUnits(Double units) { this.units = units; }
        }
    }

    // ===== Main Getters & Setters =====
    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public List<Summary> getSummary() { return summary; }
    public void setSummary(List<Summary> summary) { this.summary = summary; }

    public Transactions getTransactions() { return transactions; }
    public void setTransactions(Transactions transactions) { this.transactions = transactions; }
}
