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

	public List<EquitiesHolder> getEquitiesHolders() {
		return equitiesHolders;
	}

	public void setEquitiesHolders(List<EquitiesHolder> equitiesHolders) {
		this.equitiesHolders = equitiesHolders;
	}

	public List<EquitiesSummary> getEquitiesSummary() {
		return equitiesSummary;
	}

	public void setEquitiesSummary(List<EquitiesSummary> equitiesSummary) {
		this.equitiesSummary = equitiesSummary;
	}

	public List<EquitiesTransaction> getEquitiesTransactions() {
		return equitiesTransactions;
	}

	public void setEquitiesTransactions(List<EquitiesTransaction> equitiesTransactions) {
		this.equitiesTransactions = equitiesTransactions;
	}

	public List<MutualFundsHolder> getMutualFundsHolders() {
		return mutualFundsHolders;
	}

	public void setMutualFundsHolders(List<MutualFundsHolder> mutualFundsHolders) {
		this.mutualFundsHolders = mutualFundsHolders;
	}

	public List<MutualFundsSummary> getMutualFundsSummary() {
		return mutualFundsSummary;
	}

	public void setMutualFundsSummary(List<MutualFundsSummary> mutualFundsSummary) {
		this.mutualFundsSummary = mutualFundsSummary;
	}

	public List<MutualFundsTransaction> getMutualFundsTransactions() {
		return mutualFundsTransactions;
	}

	public void setMutualFundsTransactions(List<MutualFundsTransaction> mutualFundsTransactions) {
		this.mutualFundsTransactions = mutualFundsTransactions;
	}
}
