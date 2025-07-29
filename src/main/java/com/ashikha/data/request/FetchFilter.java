package com.ashikha.data.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchFilter {
    @JsonProperty("fiTypes")
    private List<String> fiTypes;

    @JsonProperty("fips")
    private List<String> fips;

    @JsonProperty("accountLinkRefNumbers")
    private List<String> accountLinkRefNumbers;

    public List<String> getFiTypes() {
        return fiTypes;
    }

    public void setFiTypes(List<String> fiTypes) {
        this.fiTypes = fiTypes;
    }

    public List<String> getFips() {
        return fips;
    }

    public void setFips(List<String> fips) {
        this.fips = fips;
    }

    public List<String> getAccountLinkRefNumbers() {
        return accountLinkRefNumbers;
    }

    public void setAccountLinkRefNumbers(List<String> accountLinkRefNumbers) {
        this.accountLinkRefNumbers = accountLinkRefNumbers;
    }
}
