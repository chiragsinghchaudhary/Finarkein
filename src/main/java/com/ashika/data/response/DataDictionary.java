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
	private List<EquitiesHolder> equitiesHolders;

	@JsonProperty("equities.summary")
	private List<EquitiesSummary> equitiesSummary;

	@JsonProperty("equities.transactions")
	private List<EquitiesTransaction> equitiesTransactions;

	@JsonProperty("mutual_funds.holders")
	private List<MutualFundsHolder> mutualFundsHolders;

	@JsonProperty("mutual_funds.summary")
	private List<MutualFundsSummary> mutualFundsSummary;

	@JsonProperty("mutual_funds.transactions")
	private List<MutualFundsTransaction> mutualFundsTransactions;

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

	public List<EquitiesHolder> getEquityHolders() {
		return equitiesHolders;
	}

	public void setEquityHolders(List<EquitiesHolder> equityHolders) {
		this.equitiesHolders = equityHolders;
	}

	public List<EquitiesSummary> getEquitySummary() {
		return equitiesSummary;
	}

	public void setEquitySummary(List<EquitiesSummary> equitySummary) {
		this.equitiesSummary = equitySummary;
	}

	public List<EquitiesTransaction> getEquityTransactions() {
		return equitiesTransactions;
	}

	public void setEquityTransactions(List<EquitiesTransaction> equityTransactions) {
		this.equitiesTransactions = equityTransactions;
	}

	public List<MutualFundsHolder> getMFHolders() {
		return mutualFundsHolders;
	}

	public void setMFHolders(List<MutualFundsHolder> mFHolders) {
		mutualFundsHolders = mFHolders;
	}

	public List<MutualFundsSummary> getMFSummary() {
		return mutualFundsSummary;
	}

	public void setMFSummary(List<MutualFundsSummary> mFSummary) {
		mutualFundsSummary = mFSummary;
	}

	public List<MutualFundsTransaction> getMFTransactions() {
		return mutualFundsTransactions;
	}

	public void setMFTransactions(List<MutualFundsTransaction> mFTransactions) {
		mutualFundsTransactions = mFTransactions;
	}
}
