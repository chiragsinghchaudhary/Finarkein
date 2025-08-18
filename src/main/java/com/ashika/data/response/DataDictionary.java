package com.ashika.data.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataDictionary {

	@JsonProperty("deposit.holders")
	private List<DepositHolder> depositHolders;

	@JsonProperty("deposit.summary")
	private List<DepositSummary> depositSummary;

	@JsonProperty("deposit.transactions")
	private List<DepositTransaction> depositTransactions;

	@JsonProperty("equities.holders")
	private List<EquityHolder> equityHolders;

	@JsonProperty("equities.summary")
	private List<EquitySummary> equitySummary;

	@JsonProperty("equities.transactions")
	private List<EquityTransaction> equityTransactions;

	@JsonProperty("mutual_funds.holders")
	private List<MFHolder> MFHolders;

	@JsonProperty("mutual_funds.summary")
	private List<MFSummary> MFSummary;

	@JsonProperty("mutual_funds.transactions")
	private List<MFTransaction> MFTransactions;

	public List<DepositHolder> getDepositHolders() {
		return depositHolders;
	}

	public void setDepositHolders(List<DepositHolder> depositHolders) {
		this.depositHolders = depositHolders;
	}

	public List<DepositSummary> getDepositSummary() {
		return depositSummary;
	}

	public void setDepositSummary(List<DepositSummary> depositSummary) {
		this.depositSummary = depositSummary;
	}

	public List<DepositTransaction> getDepositTransactions() {
		return depositTransactions;
	}

	public void setDepositTransactions(List<DepositTransaction> depositTransactions) {
		this.depositTransactions = depositTransactions;
	}

	public List<EquityHolder> getEquityHolders() {
		return equityHolders;
	}

	public void setEquityHolders(List<EquityHolder> equityHolders) {
		this.equityHolders = equityHolders;
	}

	public List<EquitySummary> getEquitySummary() {
		return equitySummary;
	}

	public void setEquitySummary(List<EquitySummary> equitySummary) {
		this.equitySummary = equitySummary;
	}

	public List<EquityTransaction> getEquityTransactions() {
		return equityTransactions;
	}

	public void setEquityTransactions(List<EquityTransaction> equityTransactions) {
		this.equityTransactions = equityTransactions;
	}

	public List<MFHolder> getMFHolders() {
		return MFHolders;
	}

	public void setMFHolders(List<MFHolder> mFHolders) {
		MFHolders = mFHolders;
	}

	public List<MFSummary> getMFSummary() {
		return MFSummary;
	}

	public void setMFSummary(List<MFSummary> mFSummary) {
		MFSummary = mFSummary;
	}

	public List<MFTransaction> getMFTransactions() {
		return MFTransactions;
	}

	public void setMFTransactions(List<MFTransaction> mFTransactions) {
		MFTransactions = mFTransactions;
	}
}
