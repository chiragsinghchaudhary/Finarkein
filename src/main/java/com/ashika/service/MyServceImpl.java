package com.ashika.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ashika.model.dto.ClientConsentMappingDTO;
import com.ashika.model.entity.*;
import com.ashika.repository.*;
import com.ashika.utils.Constants;
import com.ashikha.data.request.*;
import com.ashikha.data.response.*;

@Service
public class MyServceImpl implements MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyServceImpl.class);

    private final DepositHolderRepository depositHolderRepository;
    private final DepositSummaryRepository depositSummaryRepository;
    private final DepositTransactionRepository depositTransactionRepository;

    private final EquityHolderRepository equityHolderRepository;
    private final EquitySummaryRepository equitySummaryRepository;
    private final EquityTransactionRepository equityTransactionRepository;

    private final MFHolderRepository mfHolderRepository;
    private final MFSummaryRepository mfSummaryRepository;
    private final MFTransactionRepository mfTransactionRepository;

    private final ClientConsentMappingRepository clientConsentRepository;

    private FinarkeinClient finarkeinClient = new FinarkeinClient();

    public MyServceImpl(DepositHolderRepository depositHolderRepository,
                        DepositSummaryRepository depositSummaryRepository,
                        DepositTransactionRepository depositTransactionRepository, EquityHolderRepository equityHolderRepository,
                        EquitySummaryRepository equitySummaryRepository, EquityTransactionRepository equityTransactionRepository,
                        MFHolderRepository mfHolderRepository, MFSummaryRepository mfSummaryRepository,
                        MFTransactionRepository mfTransactionRepository, ClientConsentMappingRepository clientConsentRepository) {
        this.depositHolderRepository = depositHolderRepository;
        this.depositSummaryRepository = depositSummaryRepository;
        this.depositTransactionRepository = depositTransactionRepository;
        this.equityHolderRepository = equityHolderRepository;
        this.equitySummaryRepository = equitySummaryRepository;
        this.equityTransactionRepository = equityTransactionRepository;
        this.mfHolderRepository = mfHolderRepository;
        this.mfSummaryRepository = mfSummaryRepository;
        this.mfTransactionRepository = mfTransactionRepository;
        this.clientConsentRepository = clientConsentRepository;
    }

    @Override
    public boolean checkValidConsent(GetRequest getRequest) {
        long start = System.currentTimeMillis();
        logger.info("Entry: checkValidConsent | PAN: {}", maskPan(getRequest.getPan()));
        try {
            ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepository.getlatestClientConsentObject(
                    getRequest.getPan(), Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);

            boolean isValid = clientConsentMappingEntity.getState().equals(Constants.SUCCESS)
                    && clientConsentMappingEntity.getConsentStatus().equals(Constants.ACTIVE)
                    && clientConsentMappingEntity.getConsentStatus().equals(Constants.SUCCESS);

            logger.info("Exit: checkValidConsent | PAN: {} | Result: {} | Time: {} ms",
                    maskPan(getRequest.getPan()), isValid, (System.currentTimeMillis() - start));
            return isValid;
        } catch (Exception e) {
            logger.error("Error in checkValidConsent | PAN: {} | Message: {}", maskPan(getRequest.getPan()), e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public GetResultResponse getDBRecords(GetRequest getRequest) {
        long start = System.currentTimeMillis();
        logger.info("Entry: getDBRecords | PAN: {}", maskPan(getRequest.getPan()));
        try {
            List<String> idList = new ArrayList<>();
            idList.add(getRequest.getPan());

            List<DepositHolderEntity> listDepositHolderEntities = depositHolderRepository.findAllById(idList);
            List<DepositSummaryEntity> listDepositSummaryEntities = depositSummaryRepository.findAllById(idList);
            List<DepositTransactionEntity> listDepositTransactionEntities = depositTransactionRepository.findAllById(idList);
            List<EquityHolderEntity> listEquityHolderEntities = equityHolderRepository.findAllById(idList);
            List<EquitySummaryEntity> listEquitySummaryEntities = equitySummaryRepository.findAllById(idList);
            List<EquityTransactionEntity> listEquityTransactionEntities = equityTransactionRepository.findAllById(idList);
            List<MFHolderEntity> listHolderEntities = mfHolderRepository.findAllById(idList);
            List<MFSummaryEntity> listMfSummaryEntities = mfSummaryRepository.findAllById(idList);
            List<MFTransactionEntity> listMfTransactionEntities = mfTransactionRepository.findAllById(idList);

            GetResultResponse getResultResponse = new GetResultResponse();

            DepositResponse depositResponse = new DepositResponse();
            depositResponse.setHolder(mapDepositHolderEntities(listDepositHolderEntities));
            depositResponse.setSummary(mapDepositSummaryEntities(listDepositSummaryEntities));
            depositResponse.setTransactions(mapDepositTransactionEntities(listDepositTransactionEntities));

            EquityResponse equityResponse = new EquityResponse();
            equityResponse.setHolder(mapEquityHolderEntities(listEquityHolderEntities));
            equityResponse.setSummary(mapEquitySummaryEntities(listEquitySummaryEntities));
            equityResponse.setTransactions(mapEquityTransactionEntities(listEquityTransactionEntities));

            MFResponse mfResponse = new MFResponse();
            mfResponse.setHolder(mapMFHolderEntities(listHolderEntities));
            mfResponse.setSummary(mapMFSummaryEntities(listMfSummaryEntities));
            mfResponse.setTransactions(mapMFTransactionEntities(listMfTransactionEntities));

            DataDictionary dataDictionary = new DataDictionary();
            dataDictionary.setDeposit(depositResponse);
            dataDictionary.setEquity(equityResponse);
            dataDictionary.setMf(mfResponse);

            getResultResponse.setData(dataDictionary);

            logger.info("Exit: getDBRecords | PAN: {} | Time: {} ms",
                    maskPan(getRequest.getPan()), (System.currentTimeMillis() - start));
            return getResultResponse;
        } catch (Exception e) {
            logger.error("Error in getDBRecords | PAN: {} | Message: {}", maskPan(getRequest.getPan()), e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public ConsentNewRunResponse createNewRun(String workspace, String flowId,
                                              ConsentNewRunRequest consentNewRunRequest) {
        long start = System.currentTimeMillis();
        logger.info("Entry: createNewRun | workspace: {} | flowId: {} | PAN: {}",
                workspace, flowId, maskPan(consentNewRunRequest.getUser().getPan()));
        try {
            ConsentNewRunResponse consentResponse = finarkeinClient.createNewConsentRun(flowId, workspace, consentNewRunRequest);
            ClientConsentMappingDTO dto = mergeConsentRequestAndResponse(consentNewRunRequest, consentResponse);
            ClientConsentMappingEntity entity = dto.toEntity();
            ClientConsentMappingEntity savedEntity = clientConsentRepository.save(entity);
            ConsentNewRunResponse response = mapConsentEntityToResponse(savedEntity);

            logger.info("Exit: createNewRun | workspace: {} | flowId: {} | Time: {} ms",
                    workspace, flowId, (System.currentTimeMillis() - start));
            return response;
        } catch (Exception e) {
            logger.error("Error in createNewRun | workspace: {} | flowId: {} | Message: {}",
                    workspace, flowId, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public RecurringNewRunResponse createNewRunFetch(String workspace, String flowId, GetRequest getRequest) {
        long start = System.currentTimeMillis();
        logger.info("Entry: createNewRunFetch | workspace: {} | flowId: {} | PAN: {}",
                workspace, flowId, maskPan(getRequest.getPan()));
        try {
            ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepository.getlatestClientConsentObject(
                    getRequest.getPan(), Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);

            RecurringNewRunRequest recurringNewRunRequest = new RecurringNewRunRequest();
            recurringNewRunRequest.setConsentHandle(clientConsentMappingEntity.getConsentHandle());
            
            logger.info("Entry: createNewRunFetch | workspace: {} | flowId: {} | PAN: {} | ConsentHandle: {}",
                    workspace, flowId, maskPan(getRequest.getPan()), recurringNewRunRequest.getConsentHandle());

            RecurringNewRunResponse recurringResponse = finarkeinClient.createNewRecurringRun(workspace, flowId, recurringNewRunRequest);
            ClientConsentMappingDTO dto = mergeRecurringRequestAndResponse(clientConsentMappingEntity, recurringNewRunRequest, recurringResponse);

            ClientConsentMappingEntity entity = dto.toEntity();
            entity.setRunType(Constants.RECURRING);
            clientConsentRepository.save(entity);

            logger.info("Exit: createNewRunFetch | workspace: {} | flowId: {} | Time: {} ms",
                    workspace, flowId, (System.currentTimeMillis() - start));
            return recurringResponse;
        } catch (Exception e) {
            logger.error("Error in createNewRunFetch | workspace: {} | flowId: {} | Message: {}",
                    workspace, flowId, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public GetStatusResponse getStatus(String workspace, String flowId, String requestId) {
        long start = System.currentTimeMillis();
        logger.info("Entry: getStatus | workspace: {} | flowId: {} | requestId: {}",
                workspace, flowId, requestId);
        try {
            GetStatusResponse statusResponse = finarkeinClient.getStatus(workspace, flowId, requestId);
            clientConsentRepository.updateStatus(statusResponse.getState().getState(),
                    statusResponse.getState().getConsentStatus(), statusResponse.getState().getDataFetchStatus(),
                    requestId);

            logger.info("Exit: getStatus | workspace: {} | flowId: {} | requestId: {} | Time: {} ms",
                    workspace, flowId, requestId, (System.currentTimeMillis() - start));
            return statusResponse;
        } catch (Exception e) {
            logger.error("Error in getStatus | workspace: {} | flowId: {} | requestId: {} | Message: {}",
                    workspace, flowId, requestId, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public GetResultResponse getResult(String workspace, String flowId, String requestId) {
        long start = System.currentTimeMillis();
        logger.info("Entry: getResult | workspace: {} | flowId: {} | requestId: {}",
                workspace, flowId, requestId);
        try {
            GetResultResponse resultResponse = finarkeinClient.getResult(workspace, flowId, requestId);

            List<String> idList = new ArrayList<>();
            idList.add(requestId);

            if (resultResponse.getState().getDataFetchStatus().equals(Constants.SUCCESS)) {
                // Clear old data
                depositHolderRepository.deleteAllById(idList);
                depositSummaryRepository.deleteAllById(idList);
                depositTransactionRepository.deleteAllById(idList);
                equityHolderRepository.deleteAllById(idList);
                equitySummaryRepository.deleteAllById(idList);
                equityTransactionRepository.deleteAllById(idList);
                mfHolderRepository.deleteAllById(idList);
                mfSummaryRepository.deleteAllById(idList);
                mfTransactionRepository.deleteAllById(idList);

                // Save new data
                depositHolderRepository.saveAll(mapDepositHolderResponses(resultResponse.getData().getDeposit().getHolder()));
                depositSummaryRepository.saveAll(mapDepositSummaryResponses(resultResponse.getData().getDeposit().getSummary()));
                depositTransactionRepository.saveAll(mapDepositTransactionResponses(resultResponse.getData().getDeposit().getTransactions()));
                equityHolderRepository.saveAll(mapEquityHolderResponses(resultResponse.getData().getEquity().getHolder()));
                equitySummaryRepository.saveAll(mapEquitySummaryResponses(resultResponse.getData().getEquity().getSummary()));
                equityTransactionRepository.saveAll(mapEquityTransactionResponses(resultResponse.getData().getEquity().getTransactions()));
                mfHolderRepository.saveAll(mapMFHolderResponses(resultResponse.getData().getMf().getHolder()));
                mfSummaryRepository.saveAll(mapMFSummaryResponses(resultResponse.getData().getMf().getSummary()));
                mfTransactionRepository.saveAll(mapMFTransactionResponses(resultResponse.getData().getMf().getTransactions()));
            }

            logger.info("Exit: getResult | workspace: {} | flowId: {} | requestId: {} | Time: {} ms",
                    workspace, flowId, requestId, (System.currentTimeMillis() - start));
            return resultResponse;
        } catch (Exception e) {
            logger.error("Error in getResult | workspace: {} | flowId: {} | requestId: {} | Message: {}",
                    workspace, flowId, requestId, e.getMessage(), e);
            throw e;
        }
    }

    private String maskPan(String pan) {
        if (pan == null || pan.length() < 4) return "****";
        return "****" + pan.substring(pan.length() - 4);
    }

    // --- Existing helper mapping methods remain unchanged ---
    private ClientConsentMappingDTO mergeConsentRequestAndResponse(ConsentNewRunRequest request,
                                                                   ConsentNewRunResponse response) {
        return new ClientConsentMappingDTO(request.getUser().getClientUserId(), request.getUser().getPan(),
                Constants.CONSENT, null, null, null, LocalDate.parse(request.getUser().getDob()),
                response.getRequestId(), response.getConsentHandle());
    }

    private ClientConsentMappingDTO mergeRecurringRequestAndResponse(
            ClientConsentMappingEntity clientConsentMappingEntity, RecurringNewRunRequest request,
            RecurringNewRunResponse response) {
        return new ClientConsentMappingDTO(clientConsentMappingEntity.getClientCode(),
                clientConsentMappingEntity.getPan(), Constants.RECURRING, null, null, null,
                clientConsentMappingEntity.getDob(), response.getRequestId(), request.getConsentHandle());
    }

    private ConsentNewRunResponse mapConsentEntityToResponse(ClientConsentMappingEntity entity) {
        return new ConsentNewRunResponse(entity.getRequestId(), entity.getConsentHandle(), null);
    }

    private List<DepositHolder> mapDepositHolderEntities(List<DepositHolderEntity> entities) {
        List<DepositHolder> responseList = new ArrayList<>();
        for (DepositHolderEntity entity : entities) {
            DepositHolder response = new DepositHolder();
            response.setType(entity.getType());
            response.setAddress(entity.getAddress());
            response.setCkycCompliance(entity.getCkycCompliance());
            response.setDob(entity.getDob());
            response.setEmail(entity.getEmail());
            response.setLandline(entity.getLandline());
            response.setMobile(entity.getMobile());
            response.setName(entity.getName());
            response.setNominee(entity.getNominee());
            response.setPan(entity.getPan());
            responseList.add(response);
        }
        return responseList;
    }

    private List<DepositSummary> mapDepositSummaryEntities(List<DepositSummaryEntity> entities) {
        List<DepositSummary> responseList = new ArrayList<>();
        for (DepositSummaryEntity entity : entities) {
            DepositSummary response = new DepositSummary();
            response.setBalanceDatetime(entity.getBalanceDatetime());
            response.setBranch(entity.getBranch());
            response.setCurrency(entity.getCurrency());
            response.setCurrentBalance(entity.getCurrentBalance());
            response.setCurrentODLimit(entity.getCurrentODLimit());
            response.setDrawingLimit(entity.getDrawingLimit());
            response.setExchangeRate(entity.getExchangeRate());
            response.setFacility(entity.getFacility());
            response.setIfscCode(entity.getIfscCode());
            response.setMicrCode(entity.getMicrCode());
            response.setOpeningDate(entity.getOpeningDate());
            response.setStatus(entity.getStatus());
            response.setType(entity.getType());
            response.setTransactionType(entity.getTransactionType());
            response.setAmount(entity.getAmount());
            responseList.add(response);
        }
        return responseList;
    }

    private List<DepositTransaction> mapDepositTransactionEntities(List<DepositTransactionEntity> entities) {
        List<DepositTransaction> responseList = new ArrayList<>();
        for (DepositTransactionEntity entity : entities) {
            DepositTransaction response = new DepositTransaction();
            response.setAmount(entity.getAmount());
            response.setCurrentBalance(entity.getCurrentBalance());
            response.setMode(entity.getMode());
            response.setNarration(entity.getNarration());
            response.setReference(entity.getReference());
            response.setTransactionId(entity.getTransactionId());
            response.setTransactionTimestamp(entity.getTransactionTimestamp());
            response.setType(entity.getType());
            response.setValueDate(entity.getValueDate());
            responseList.add(response);
        }
        return responseList;
    }

    private List<EquityHolder> mapEquityHolderEntities(List<EquityHolderEntity> entities) {
        List<EquityHolder> responseList = new ArrayList<>();
        for (EquityHolderEntity entity : entities) {
            EquityHolder response = new EquityHolder();
            response.setAddress(entity.getAddress());
            response.setDematId(entity.getDematId());
            response.setDob(entity.getDob());
            response.setEmail(entity.getEmail());
            response.setKycCompliance(entity.getKycCompliance());
            response.setLandline(entity.getLandline());
            response.setMobile(entity.getMobile());
            response.setName(entity.getName());
            response.setNominee(entity.getNominee());
            response.setPan(entity.getPan());
            responseList.add(response);
        }
        return responseList;
    }
}

	private List<EquitySummary> mapEquitySummaryEntities(List<EquitySummaryEntity> entities) {
    logger.info("Mapping EquitySummaryEntity list to EquitySummary response. Total entities: {}", 
                entities != null ? entities.size() : 0);
    List<EquitySummary> responseList = new ArrayList<>();
    for (EquitySummaryEntity entity : entities) {
        logger.debug("Mapping EquitySummaryEntity: {}", entity);
        EquitySummary response = new EquitySummary();
        response.setCurrentValue(entity.getCurrentValue());
        response.setHoldingMode(entity.getHoldingMode());
        response.setIsin(entity.getIsin());
        response.setIsinDescription(entity.getIsinDescription());
        response.setIssuerName(entity.getIssuerName());
        response.setLastTradedPrice(entity.getLastTradedPrice());
        response.setUnits(entity.getUnits());
        responseList.add(response);
    }
    logger.info("EquitySummary mapping completed. Total responses: {}", responseList.size());
    return responseList;
}

private List<EquityTransaction> mapEquityTransactionEntities(List<EquityTransactionEntity> entities) {
    logger.info("Mapping EquityTransactionEntity list to EquityTransaction response. Total entities: {}", 
                entities != null ? entities.size() : 0);
    List<EquityTransaction> responseList = new ArrayList<>();
    for (EquityTransactionEntity entity : entities) {
        logger.debug("Mapping EquityTransactionEntity: {}", entity);
        EquityTransaction response = new EquityTransaction();
        response.setCompanyName(entity.getCompanyName());
        response.setEquityCategory(entity.getEquityCategory());
        response.setExchange(entity.getExchange());
        response.setIsin(entity.getIsin());
        response.setIsinDescription(entity.getIsinDescription());
        response.setNarration(entity.getNarration());
        response.setOrderId(entity.getOrderId());
        response.setRate(entity.getRate());
        response.setTransactionDateTime(entity.getTransactionDateTime());
        response.setTxnId(entity.getTxnId());
        response.setType(entity.getType());
        response.setUnits(entity.getUnits());
        responseList.add(response);
    }
    logger.info("EquityTransaction mapping completed. Total responses: {}", responseList.size());
    return responseList;
}

private List<MFHolder> mapMFHolderEntities(List<MFHolderEntity> entities) {
    logger.info("Mapping MFHolderEntity list to MFHolder response. Total entities: {}", 
                entities != null ? entities.size() : 0);
    List<MFHolder> responseList = new ArrayList<>();
    for (MFHolderEntity entity : entities) {
        logger.debug("Mapping MFHolderEntity: {}", entity);
        MFHolder response = new MFHolder();
        response.setAddress(entity.getAddress());
        response.setDematId(entity.getDematId());
        response.setDob(entity.getDob());
        response.setEmail(entity.getEmail());
        response.setFolioNo(entity.getFolioNo());
        response.setKycCompliance(entity.getKycCompliance());
        response.setLandline(entity.getLandline());
        response.setMobile(entity.getMobile());
        response.setName(entity.getName());
        response.setNominee(entity.getNominee());
        response.setPan(entity.getPan());
        responseList.add(response);
    }
    logger.info("MFHolder mapping completed. Total responses: {}", responseList.size());
    return responseList;
}

private List<MFSummary> mapMFSummaryEntities(List<MFSummaryEntity> entities) {
    logger.info("Mapping MFSummaryEntity list to MFSummary response. Total entities: {}", 
                entities != null ? entities.size() : 0);
    List<MFSummary> responseList = new ArrayList<>();
    for (MFSummaryEntity entity : entities) {
        logger.debug("Mapping MFSummaryEntity: {}", entity);
        MFSummary response = new MFSummary();
        response.setCostValue(entity.getCostValue());
        response.setCurrentValue(entity.getCurrentValue());
        response.setFatcaStatus(entity.getFatcaStatus());
        response.setAmc(entity.getAmc());
        response.setAmfiCode(entity.getAmfiCode());
        response.setClosingUnits(entity.getClosingUnits());
        response.setFolioNo(entity.getFolioNo());
        response.setIsin(entity.getIsin());
        response.setIsinDescription(entity.getIsinDescription());
        response.setLienUnits(entity.getLienUnits());
        response.setLockinUnits(entity.getLockinUnits());
        response.setNav(entity.getNav());
        response.setNavDate(entity.getNavDate());
        response.setRegistrar(entity.getRegistrar());
        response.setSchemeCategory(entity.getSchemeCategory());
        response.setSchemeCode(entity.getSchemeCode());
        response.setSchemeOption(entity.getSchemeOption());
        response.setSchemeTypes(entity.getSchemeTypes());
        response.setUcc(entity.getUcc());
        responseList.add(response);
    }
    logger.info("MFSummary mapping completed. Total responses: {}", responseList.size());
    return responseList;
}

private List<MFTransaction> mapMFTransactionEntities(List<MFTransactionEntity> entities) {
    logger.info("Mapping MFTransactionEntity list to MFTransaction response. Total entities: {}", 
                entities != null ? entities.size() : 0);
    List<MFTransaction> responseList = new ArrayList<>();
    for (MFTransactionEntity entity : entities) {
        logger.debug("Mapping MFTransactionEntity: {}", entity);
        MFTransaction response = new MFTransaction();
        response.setAmc(entity.getAmc());
        response.setAmfiCode(entity.getAmfiCode());
        response.setAmount(entity.getAmount());
        response.setIsin(entity.getIsin());
        response.setIsinDescription(entity.getIsinDescription());
        response.setLockInDays(entity.getLockInDays());
        response.setLockInFlag(entity.getLockInFlag());
        response.setMode(entity.getMode());
        response.setNarration(entity.getNarration());
        response.setNav(entity.getNav());
        response.setNavDate(entity.getNavDate());
        response.setRegistrar(entity.getRegistrar());
        response.setSchemeCode(entity.getSchemeCode());
        response.setSchemePlan(entity.getSchemePlan());
        response.setTransactionDate(entity.getTransactionDate());
        response.setTxnId(entity.getTxnId());
        response.setType(entity.getType());
        response.setUcc(entity.getUcc());
        response.setUnits(entity.getUnits());
        responseList.add(response);
    }
    logger.info("MFTransaction mapping completed. Total responses: {}", responseList.size());
    return responseList;
}
