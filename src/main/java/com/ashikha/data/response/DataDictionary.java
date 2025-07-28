package com.ashikha.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataDictionary {

    @JsonProperty("deposit")
    private DepositResponse deposit;

    @JsonProperty("mf")
    private MFResponse mf;

    @JsonProperty("equity")
    private EquityResponse equity;

    // Getters & Setters
    public DepositResponse getDeposit() { return deposit; }
    public void setDeposit(DepositResponse deposit) { this.deposit = deposit; }

    public MFResponse getMf() { return mf; }
    public void setMf(MFResponse mf) { this.mf = mf; }

    public EquityResponse getEquity() { return equity; }
    public void setEquity(EquityResponse equity) { this.equity = equity; }
}

