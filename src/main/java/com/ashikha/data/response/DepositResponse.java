package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Corrected Response structure for Deposit Account
 * Profile → Summary → Transactions
 */
public class DepositResponse {

    @JsonProperty("profile")
    private Profile profile;

    @JsonProperty("summary")
    private List<Summary> summary;

    @JsonProperty("transactions")
    private Transactions transactions;

    // ================== Inner Classes ==================

    /** Profile Section */
    public static class Profile {
        @JsonProperty("type")
        private String type;

        @JsonProperty("address")
        private String address;

        @JsonProperty("ckycCompliance")
        private Boolean ckycCompliance;

        @JsonProperty("dob")
        private Long dob;

        @JsonProperty("email")
        private String email;

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
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public Boolean getCkycCompliance() { return ckycCompliance; }
        public void setCkycCompliance(Boolean ckycCompliance) { this.ckycCompliance = ckycCompliance; }

        public Long getDob() { return dob; }
        public void setDob(Long dob) { this.dob = dob; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

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

    /** Summary Section */
    public static class Summary {
        @JsonProperty("balanceDatetime")
        private Long balanceDatetime;

        @JsonProperty("branch")
        private String branch;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("currentBalance")
        private Double currentBalance;

        @JsonProperty("currentODLimit")
        private Double currentODLimit;

        @JsonProperty("drawingLimit")
        private Double drawingLimit;

        @JsonProperty("exchangeRate")
        private String exchangeRate;

        @JsonProperty("facility")
        private String facility;

        @JsonProperty("ifscCode")
        private String ifscCode;

        @JsonProperty("micrCode")
        private String micrCode;

        @JsonProperty("openingDate")
        private String openingDate;

        @JsonProperty("status")
        private String status;

        @JsonProperty("type")
        private String type;

        @JsonProperty("transactionType")
        private String transactionType;

        @JsonProperty("amount")
        private Double amount;

        // Getters & Setters
        public Long getBalanceDatetime() { return balanceDatetime; }
        public void setBalanceDatetime(Long balanceDatetime) { this.balanceDatetime = balanceDatetime; }

        public String getBranch() { return branch; }
        public void setBranch(String branch) { this.branch = branch; }

        public String getCurrency() { return currency; }
        public void setCurrency(String currency) { this.currency = currency; }

        public Double getCurrentBalance() { return currentBalance; }
        public void setCurrentBalance(Double currentBalance) { this.currentBalance = currentBalance; }

        public Double getCurrentODLimit() { return currentODLimit; }
        public void setCurrentODLimit(Double currentODLimit) { this.currentODLimit = currentODLimit; }

        public Double getDrawingLimit() { return drawingLimit; }
        public void setDrawingLimit(Double drawingLimit) { this.drawingLimit = drawingLimit; }

        public String getExchangeRate() { return exchangeRate; }
        public void setExchangeRate(String exchangeRate) { this.exchangeRate = exchangeRate; }

        public String getFacility() { return facility; }
        public void setFacility(String facility) { this.facility = facility; }

        public String getIfscCode() { return ifscCode; }
        public void setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }

        public String getMicrCode() { return micrCode; }
        public void setMicrCode(String micrCode) { this.micrCode = micrCode; }

        public String getOpeningDate() { return openingDate; }
        public void setOpeningDate(String openingDate) { this.openingDate = openingDate; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getTransactionType() { return transactionType; }
        public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

        public Double getAmount() { return amount; }
        public void setAmount(Double amount) { this.amount = amount; }
    }

    /** Transactions Section */
    public static class Transactions {
        @JsonProperty("startDate")
        private String startDate;

        @JsonProperty("endDate")
        private String endDate;

        @JsonProperty("transaction")
        private List<Transaction> transaction;

        /** Transaction Details */
        public static class Transaction {
            @JsonProperty("amount")
            private Double amount;

            @JsonProperty("currentBalance")
            private Double currentBalance;

            @JsonProperty("mode")
            private String mode;

            @JsonProperty("narration")
            private String narration;

            @JsonProperty("reference")
            private String reference;

            @JsonProperty("transactionId")
            private String transactionId;

            @JsonProperty("transactionTimestamp")
            private Long transactionTimestamp;

            @JsonProperty("type")
            private String type;

            @JsonProperty("valueDate")
            private Long valueDate;

            // Getters & Setters
            public Double getAmount() { return amount; }
            public void setAmount(Double amount) { this.amount = amount; }

            public Double getCurrentBalance() { return currentBalance; }
            public void setCurrentBalance(Double currentBalance) { this.currentBalance = currentBalance; }

            public String getMode() { return mode; }
            public void setMode(String mode) { this.mode = mode; }

            public String getNarration() { return narration; }
            public void setNarration(String narration) { this.narration = narration; }

            public String getReference() { return reference; }
            public void setReference(String reference) { this.reference = reference; }

            public String getTransactionId() { return transactionId; }
            public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

            public Long getTransactionTimestamp() { return transactionTimestamp; }
            public void setTransactionTimestamp(Long transactionTimestamp) { this.transactionTimestamp = transactionTimestamp; }

            public String getType() { return type; }
            public void setType(String type) { this.type = type; }

            public Long getValueDate() { return valueDate; }
            public void setValueDate(Long valueDate) { this.valueDate = valueDate; }
        }

        // Getters & Setters
        public String getStartDate() { return startDate; }
        public void setStartDate(String startDate) { this.startDate = startDate; }

        public String getEndDate() { return endDate; }
        public void setEndDate(String endDate) { this.endDate = endDate; }

        public List<Transaction> getTransaction() { return transaction; }
        public void setTransaction(List<Transaction> transaction) { this.transaction = transaction; }
    }

    // ================== Getters & Setters for Main Class ==================

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public List<Summary> getSummary() { return summary; }
    public void setSummary(List<Summary> summary) { this.summary = summary; }

    public Transactions getTransactions() { return transactions; }
    public void setTransactions(Transactions transactions) { this.transactions = transactions; }
}
