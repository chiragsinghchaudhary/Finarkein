package com.ashika.service;

import com.ashika.model.dto.*;

import java.util.List;
import java.util.Optional;

public interface MyService {

    // ================== Deposit Profile ==================
    List<DepositProfileDTO> getAllDepositProfiles();
    Optional<DepositProfileDTO> getDepositProfileById(Long id);
    DepositProfileDTO saveDepositProfile(DepositProfileDTO dto);
    DepositProfileDTO updateDepositProfile(Long id, DepositProfileDTO dto);
    void deleteDepositProfile(Long id);

    // ================== Deposit Summary ==================
    List<DepositSummaryDTO> getAllDepositSummaries();
    Optional<DepositSummaryDTO> getDepositSummaryById(Long id);
    DepositSummaryDTO saveDepositSummary(DepositSummaryDTO dto);
    DepositSummaryDTO updateDepositSummary(Long id, DepositSummaryDTO dto);
    void deleteDepositSummary(Long id);

    // ================== Deposit Transaction ==================
    List<DepositTransactionDTO> getAllDepositTransactions();
    Optional<DepositTransactionDTO> getDepositTransactionById(Long id);
    DepositTransactionDTO saveDepositTransaction(DepositTransactionDTO dto);
    DepositTransactionDTO updateDepositTransaction(Long id, DepositTransactionDTO dto);
    void deleteDepositTransaction(Long id);

    // ================== Equity Profile ==================
    List<EquityProfileDTO> getAllEquityProfiles();
    Optional<EquityProfileDTO> getEquityProfileById(Long id);
    EquityProfileDTO saveEquityProfile(EquityProfileDTO dto);
    EquityProfileDTO updateEquityProfile(Long id, EquityProfileDTO dto);
    void deleteEquityProfile(Long id);

    // ================== Equity Summary ==================
    List<EquitySummaryDTO> getAllEquitySummaries();
    Optional<EquitySummaryDTO> getEquitySummaryById(Long id);
    EquitySummaryDTO saveEquitySummary(EquitySummaryDTO dto);
    EquitySummaryDTO updateEquitySummary(Long id, EquitySummaryDTO dto);
    void deleteEquitySummary(Long id);

    // ================== Equity Transaction ==================
    List<EquityTransactionDTO> getAllEquityTransactions();
    Optional<EquityTransactionDTO> getEquityTransactionById(Long id);
    EquityTransactionDTO saveEquityTransaction(EquityTransactionDTO dto);
    EquityTransactionDTO updateEquityTransaction(Long id, EquityTransactionDTO dto);
    void deleteEquityTransaction(Long id);

    // ================== Mutual Fund Profile ==================
    List<MFProfileDTO> getAllMFProfiles();
    Optional<MFProfileDTO> getMFProfileById(Long id);
    MFProfileDTO saveMFProfile(MFProfileDTO dto);
    MFProfileDTO updateMFProfile(Long id, MFProfileDTO dto);
    void deleteMFProfile(Long id);

    // ================== Mutual Fund Summary ==================
    List<MFSummaryDTO> getAllMFSummaries();
    Optional<MFSummaryDTO> getMFSummaryById(Long id);
    MFSummaryDTO saveMFSummary(MFSummaryDTO dto);
    MFSummaryDTO updateMFSummary(Long id, MFSummaryDTO dto);
    void deleteMFSummary(Long id);

    // ================== Mutual Fund Transaction ==================
    List<MFTransactionDTO> getAllMFTransactions();
    Optional<MFTransactionDTO> getMFTransactionById(Long id);
    MFTransactionDTO saveMFTransaction(MFTransactionDTO dto);
    MFTransactionDTO updateMFTransaction(Long id, MFTransactionDTO dto);
    void deleteMFTransaction(Long id);

    // ================== Client Consent Mapping ==================
    List<ClientConsentMappingDTO> getAllClientConsents();
    Optional<ClientConsentMappingDTO> getClientConsentById(Long id);
    ClientConsentMappingDTO saveClientConsent(ClientConsentMappingDTO dto);
    ClientConsentMappingDTO updateClientConsent(Long id, ClientConsentMappingDTO dto);
    void deleteClientConsent(Long id);

    // ================== Client Consent Mapping History ==================
    List<ClientConsentMappingHistDTO> getAllClientConsentHistories();
    Optional<ClientConsentMappingHistDTO> getClientConsentHistoryById(Long id);
    ClientConsentMappingHistDTO saveClientConsentHistory(ClientConsentMappingHistDTO dto);
    ClientConsentMappingHistDTO updateClientConsentHistory(Long id, ClientConsentMappingHistDTO dto);
    void deleteClientConsentHistory(Long id);
}
