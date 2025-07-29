package com.ashika.service;

import com.ashika.model.dto.*;

import java.util.List;
import java.util.Optional;

public interface MyService {

    // ================== Deposit ==================
    List<DepositSummaryDTO> getAllDepositSummaries();
    Optional<DepositSummaryDTO> getDepositSummaryById(Long id);
    DepositSummaryDTO saveDepositSummary(DepositSummaryDTO dto);
    DepositSummaryDTO updateDepositSummary(Long id, DepositSummaryDTO dto);
    void deleteDepositSummary(Long id);

    List<DepositTransactionDTO> getAllDepositTransactions();
    Optional<DepositTransactionDTO> getDepositTransactionById(Long id);
    DepositTransactionDTO saveDepositTransaction(DepositTransactionDTO dto);
    DepositTransactionDTO updateDepositTransaction(Long id, DepositTransactionDTO dto);
    void deleteDepositTransaction(Long id);

    // ================== Equity ==================
    List<EquityProfileDTO> getAllEquityProfiles();
    Optional<EquityProfileDTO> getEquityProfileById(Long id);
    EquityProfileDTO saveEquityProfile(EquityProfileDTO dto);
    EquityProfileDTO updateEquityProfile(Long id, EquityProfileDTO dto);
    void deleteEquityProfile(Long id);

    List<EquitySummaryDTO> getAllEquitySummaries();
    Optional<EquitySummaryDTO> getEquitySummaryById(Long id);
    EquitySummaryDTO saveEquitySummary(EquitySummaryDTO dto);
    EquitySummaryDTO updateEquitySummary(Long id, EquitySummaryDTO dto);
    void deleteEquitySummary(Long id);

    List<EquityTransactionDTO> getAllEquityTransactions();
    Optional<EquityTransactionDTO> getEquityTransactionById(Long id);
    EquityTransactionDTO saveEquityTransaction(EquityTransactionDTO dto);
    EquityTransactionDTO updateEquityTransaction(Long id, EquityTransactionDTO dto);
    void deleteEquityTransaction(Long id);

    // ================== Mutual Fund ==================
    List<MFProfileDTO> getAllMFProfiles();
    Optional<MFProfileDTO> getMFProfileById(Long id);
    MFProfileDTO saveMFProfile(MFProfileDTO dto);
    MFProfileDTO updateMFProfile(Long id, MFProfileDTO dto);
    void deleteMFProfile(Long id);

    List<MFSummaryDTO> getAllMFSummaries();
    Optional<MFSummaryDTO> getMFSummaryById(Long id);
    MFSummaryDTO saveMFSummary(MFSummaryDTO dto);
    MFSummaryDTO updateMFSummary(Long id, MFSummaryDTO dto);
    void deleteMFSummary(Long id);

    List<MFTransactionDTO> getAllMFTransactions();
    Optional<MFTransactionDTO> getMFTransactionById(Long id);
    MFTransactionDTO saveMFTransaction(MFTransactionDTO dto);
    MFTransactionDTO updateMFTransaction(Long id, MFTransactionDTO dto);
    void deleteMFTransaction(Long id);

    // ================== Client Consent ==================
    List<ClientConsentMappingDTO> getAllClientConsents();
    Optional<ClientConsentMappingDTO> getClientConsentById(Long id);
    ClientConsentMappingDTO saveClientConsent(ClientConsentMappingDTO dto);
    ClientConsentMappingDTO updateClientConsent(Long id, ClientConsentMappingDTO dto);
    void deleteClientConsent(Long id);

    List<ClientConsentMappingHistDTO> getAllClientConsentHistories();
    Optional<ClientConsentMappingHistDTO> getClientConsentHistoryById(Long id);
    ClientConsentMappingHistDTO saveClientConsentHistory(ClientConsentMappingHistDTO dto);
    ClientConsentMappingHistDTO updateClientConsentHistory(Long id, ClientConsentMappingHistDTO dto);
    void deleteClientConsentHistory(Long id);
}
