package com.ashika.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashika.model.dto.ClientConsentMappingDTO;
import com.ashika.model.entity.ClientConsentMappingEntity;
import com.ashika.model.entity.DepositHolderEntity;
import com.ashika.model.entity.DepositSummaryEntity;
import com.ashika.model.entity.DepositTransactionEntity;
import com.ashika.model.entity.EquityHolderEntity;
import com.ashika.model.entity.EquitySummaryEntity;
import com.ashika.model.entity.EquityTransactionEntity;
import com.ashika.model.entity.MFHolderEntity;
import com.ashika.model.entity.MFSummaryEntity;
import com.ashika.model.entity.MFTransactionEntity;
import com.ashika.repository.ClientConsentMappingRepository;
import com.ashika.repository.DepositHolderRepository;
import com.ashika.repository.DepositSummaryRepository;
import com.ashika.repository.DepositTransactionRepository;
import com.ashika.repository.EquityHolderRepository;
import com.ashika.repository.EquitySummaryRepository;
import com.ashika.repository.EquityTransactionRepository;
import com.ashika.repository.MFHolderRepository;
import com.ashika.repository.MFSummaryRepository;
import com.ashika.repository.MFTransactionRepository;
import com.ashika.utils.Constants;
import com.ashikha.data.request.ConsentNewRunRequest;
import com.ashikha.data.request.GetRequest;
import com.ashikha.data.request.RecurringNewRunRequest;
import com.ashikha.data.response.ConsentNewRunResponse;
import com.ashikha.data.response.DataDictionary;
import com.ashikha.data.response.DepositHolder;
import com.ashikha.data.response.DepositResponse;
import com.ashikha.data.response.DepositSummary;
import com.ashikha.data.response.DepositTransaction;
import com.ashikha.data.response.EquityHolder;
import com.ashikha.data.response.EquityResponse;
import com.ashikha.data.response.EquitySummary;
import com.ashikha.data.response.EquityTransaction;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.MFHolder;
import com.ashikha.data.response.MFResponse;
import com.ashikha.data.response.MFSummary;
import com.ashikha.data.response.MFTransaction;
import com.ashikha.data.response.RecurringNewRunResponse;

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
    logger.info("Checking valid consent for PAN: {}", getRequest.getPan());

    ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepository.getlatestClientConsentObject(
            getRequest.getPan(), Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);

    if (clientConsentMappingEntity != null) {
        logger.debug("Consent record found: State={}, ConsentStatus={}", 
                     clientConsentMappingEntity.getState(), clientConsentMappingEntity.getConsentStatus());

        if (clientConsentMappingEntity.getState().equals(Constants.SUCCESS)
                && clientConsentMappingEntity.getConsentStatus().equals(Constants.ACTIVE)
                && clientConsentMappingEntity.getConsentStatus().equals(Constants.SUCCESS)) {
            logger.info("Consent is VALID for PAN: {}", getRequest.getPan());
            return true;
        } else {
            logger.warn("Consent is NOT valid for PAN: {}", getRequest.getPan());
            return false;
        }
    } else {
        logger.warn("No consent record found for PAN: {}", getRequest.getPan());
        return false;
    }
}


	@Override
public GetResultResponse getDBRecords(GetRequest getRequest) {
    long startTime = System.currentTimeMillis();
    logger.info("Entry: getDBRecords for PAN: {}", getRequest.getPan());

    List<String> idList = new ArrayList<>();
    idList.add(getRequest.getPan());

    List<DepositHolderEntity> listDepositHolderEntities = depositHolderRepository.findAllById(idList);
    logger.debug("Fetched {} DepositHolder records", listDepositHolderEntities.size());

    List<DepositSummaryEntity> listDepositSummaryEntities = depositSummaryRepository.findAllById(idList);
    logger.debug("Fetched {} DepositSummary records", listDepositSummaryEntities.size());

    List<DepositTransactionEntity> listDepositTransactionEntities = depositTransactionRepository.findAllById(idList);
    logger.debug("Fetched {} DepositTransaction records", listDepositTransactionEntities.size());

    List<EquityHolderEntity> listEquityHolderEntities = equityHolderRepository.findAllById(idList);
    logger.debug("Fetched {} EquityHolder records", listEquityHolderEntities.size());

    List<EquitySummaryEntity> listEquitySummaryEntities = equitySummaryRepository.findAllById(idList);
    logger.debug("Fetched {} EquitySummary records", listEquitySummaryEntities.size());

    List<EquityTransactionEntity> listEquityTransactionEntities = equityTransactionRepository.findAllById(idList);
    logger.debug("Fetched {} EquityTransaction records", listEquityTransactionEntities.size());

    List<MFHolderEntity> listHolderEntities = mfHolderRepository.findAllById(idList);
    logger.debug("Fetched {} MFHolder records", listHolderEntities.size());

    List<MFSummaryEntity> listMfSummaryEntities = mfSummaryRepository.findAllById(idList);
    logger.debug("Fetched {} MFSummary records", listMfSummaryEntities.size());

    List<MFTransactionEntity> listMfTransactionEntities = mfTransactionRepository.findAllById(idList);
    logger.debug("Fetched {} MFTransaction records", listMfTransactionEntities.size());

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

    long timeTaken = System.currentTimeMillis() - startTime;
    logger.info("Exit: getDBRecords for PAN: {} | ProcessingTime: {} ms", getRequest.getPan(), timeTaken);

    return getResultResponse;
}

	@Override
public ConsentNewRunResponse createNewRun(String workspace, String flowId,
        ConsentNewRunRequest consentNewRunRequest) {
    logger.info("Entry: createNewRun | workspace: {} | flowId: {} | PAN: {}", 
                workspace, flowId, consentNewRunRequest.getUser().getPan());

    ConsentNewRunResponse consentResponse = finarkeinClient.createNewConsentRun(flowId, workspace,
            consentNewRunRequest);

    logger.debug("ConsentNewRun API Response | requestId: {} | consentHandle: {}", 
                 consentResponse.getRequestId(), consentResponse.getConsentHandle());

    ClientConsentMappingDTO dto = mergeConsentRequestAndResponse(consentNewRunRequest, consentResponse);
    ClientConsentMappingEntity entity = dto.toEntity();

    ClientConsentMappingEntity savedEntity = clientConsentRepository.save(entity);
    logger.info("Consent entity saved successfully for PAN: {} | requestId: {}", 
                savedEntity.getPan(), savedEntity.getRequestId());

    ConsentNewRunResponse response = mapConsentEntityToResponse(savedEntity);
    logger.info("Exit: createNewRun | Returning ConsentNewRunResponse for requestId: {}", 
                response.getRequestId());

    return response;
}

	@Override
public RecurringNewRunResponse createNewRunFetch(String workspace, String flowId, GetRequest getRequest) {
    logger.info("Entry: createNewRunFetch | workspace: {} | flowId: {} | PAN: {}", 
                workspace, flowId, getRequest.getPan());

    ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepository.getlatestClientConsentObject(
            getRequest.getPan(), Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);

    logger.debug("Fetched latest consent mapping entity with consentHandle: {}", 
                 clientConsentMappingEntity.getConsentHandle());

    RecurringNewRunRequest recurringNewRunRequest = new RecurringNewRunRequest();
    recurringNewRunRequest.setConsentHandle(clientConsentMappingEntity.getConsentHandle());

    RecurringNewRunResponse recurringResponse = finarkeinClient.createNewRecurringRun(workspace, flowId,
            recurringNewRunRequest);

    logger.debug("RecurringNewRun API Response | requestId: {}", recurringResponse.getRequestId());

    ClientConsentMappingDTO dto = mergeRecurringRequestAndResponse(clientConsentMappingEntity,
            recurringNewRunRequest, recurringResponse);

    ClientConsentMappingEntity entity = dto.toEntity();
    entity.setRunType(Constants.RECURRING);

    clientConsentRepository.save(entity);
    logger.info("Recurring run entity saved successfully for PAN: {} | requestId: {}", 
                entity.getPan(), entity.getRequestId());

    logger.info("Exit: createNewRunFetch | Returning RecurringNewRunResponse for requestId: {}", 
                recurringResponse.getRequestId());

    return recurringResponse;
}

	@Override
public GetStatusResponse getStatus(String workspace, String flowId, String requestId) {
    logger.info("Entry: getStatus | workspace: {} | flowId: {} | requestId: {}", 
                workspace, flowId, requestId);

    GetStatusResponse statusResponse = finarkeinClient.getStatus(workspace, flowId, requestId);
    logger.debug("Fetched status from Finarkein API | state: {} | consentStatus: {} | dataFetchStatus: {}",
                 statusResponse.getState().getState(),
                 statusResponse.getState().getConsentStatus(),
                 statusResponse.getState().getDataFetchStatus());

    clientConsentRepository.updateStatus(statusResponse.getState().getState(),
            statusResponse.getState().getConsentStatus(),
            statusResponse.getState().getDataFetchStatus(),
            requestId);

    logger.info("Updated client consent status in DB for requestId: {}", requestId);
    logger.info("Exit: getStatus | Returning GetStatusResponse for requestId: {}", requestId);

    return statusResponse;
}

	@Override
public GetResultResponse getResult(String workspace, String flowId, String requestId) {
    logger.info("Entry: getResult | workspace: {} | flowId: {} | requestId: {}", workspace, flowId, requestId);

    GetResultResponse resultResponse = finarkeinClient.getResult(workspace, flowId, requestId);
    logger.debug("Fetched result from Finarkein API | dataFetchStatus: {}", 
                 resultResponse.getState().getDataFetchStatus());

    List<String> idList = new ArrayList<>();
    idList.add(requestId);

    if (resultResponse.getState().getDataFetchStatus().equals(Constants.SUCCESS)) {
        logger.info("Data fetch status SUCCESS | Clearing existing records for requestId: {}", requestId);

        // Deletes
        depositHolderRepository.deleteAllById(idList);
        depositSummaryRepository.deleteAllById(idList);
        depositTransactionRepository.deleteAllById(idList);
        logger.debug("Deleted deposit records for requestId: {}", requestId);

        equityHolderRepository.deleteAllById(idList);
        equitySummaryRepository.deleteAllById(idList);
        equityTransactionRepository.deleteAllById(idList);
        logger.debug("Deleted equity records for requestId: {}", requestId);

        mfHolderRepository.deleteAllById(idList);
        mfSummaryRepository.deleteAllById(idList);
        mfTransactionRepository.deleteAllById(idList);
        logger.debug("Deleted MF records for requestId: {}", requestId);

        // Saves
        depositHolderRepository.saveAll(mapDepositHolderResponses(resultResponse.getData().getDeposit().getHolder()));
        depositSummaryRepository.saveAll(mapDepositSummaryResponses(resultResponse.getData().getDeposit().getSummary()));
        depositTransactionRepository.saveAll(mapDepositTransactionResponses(resultResponse.getData().getDeposit().getTransactions()));
        logger.debug("Saved deposit data for requestId: {}", requestId);

        equityHolderRepository.saveAll(mapEquityHolderResponses(resultResponse.getData().getEquity().getHolder()));
        equitySummaryRepository.saveAll(mapEquitySummaryResponses(resultResponse.getData().getEquity().getSummary()));
        equityTransactionRepository.saveAll(mapEquityTransactionResponses(resultResponse.getData().getEquity().getTransactions()));
        logger.debug("Saved equity data for requestId: {}", requestId);

        mfHolderRepository.saveAll(mapMFHolderResponses(resultResponse.getData().getMf().getHolder()));
        mfSummaryRepository.saveAll(mapMFSummaryResponses(resultResponse.getData().getMf().getSummary()));
        mfTransactionRepository.saveAll(mapMFTransactionResponses(resultResponse.getData().getMf().getTransactions()));
        logger.debug("Saved MF data for requestId: {}", requestId);
    } else {
        logger.warn("Data fetch status is NOT SUCCESS for requestId: {} | Status: {}", 
                    requestId, resultResponse.getState().getDataFetchStatus());
    }

    logger.info("Exit: getResult | Returning GetResultResponse for requestId: {}", requestId);
    return resultResponse;
}

	private ClientConsentMappingDTO mergeConsentRequestAndResponse(ConsentNewRunRequest request,
        ConsentNewRunResponse response) {
    logger.debug("Merging ConsentNewRunRequest and ConsentNewRunResponse | clientUserId: {} | pan: {} | requestId: {} | consentHandle: {}",
            request.getUser().getClientUserId(),
            request.getUser().getPan(),
            response.getRequestId(),
            response.getConsentHandle());

    return new ClientConsentMappingDTO(request.getUser().getClientUserId(), request.getUser().getPan(),
            Constants.CONSENT, null, null, null, LocalDate.parse(request.getUser().getDob()),
            response.getRequestId(), response.getConsentHandle());
}


	private ClientConsentMappingDTO mergeRecurringRequestAndResponse(
        ClientConsentMappingEntity clientConsentMappingEntity, RecurringNewRunRequest request,
        RecurringNewRunResponse response) {

    logger.debug("Merging RecurringNewRunRequest and Response | clientCode: {} | pan: {} | existingConsentHandle: {} | newRequestId: {}",
            clientConsentMappingEntity.getClientCode(),
            clientConsentMappingEntity.getPan(),
            request.getConsentHandle(),
            response.getRequestId());

    return new ClientConsentMappingDTO(clientConsentMappingEntity.getClientCode(),
            clientConsentMappingEntity.getPan(), Constants.RECURRING, null, null, null,
            clientConsentMappingEntity.getDob(), response.getRequestId(), request.getConsentHandle());
}

	private ConsentNewRunResponse mapConsentEntityToResponse(ClientConsentMappingEntity entity) {
    logger.debug("Mapping ClientConsentMappingEntity to ConsentNewRunResponse | requestId: {} | consentHandle: {}",
            entity.getRequestId(), entity.getConsentHandle());

    return new ConsentNewRunResponse(entity.getRequestId(), entity.getConsentHandle(), null);
}


	private List<DepositHolder> mapDepositHolderEntities(List<DepositHolderEntity> entities) {
    logger.debug("Mapping {} DepositHolderEntity records to DepositHolder response objects", 
            (entities != null ? entities.size() : 0));

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

    logger.debug("Successfully mapped {} DepositHolder response objects", responseList.size());
    return responseList;
}


	private List<DepositSummary> mapDepositSummaryEntities(List<DepositSummaryEntity> entities) {
    logger.debug("Mapping {} DepositSummaryEntity records to DepositSummary response objects", 
            (entities != null ? entities.size() : 0));

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

    logger.debug("Successfully mapped {} DepositSummary response objects", responseList.size());
    return responseList;
}

	private List<DepositTransaction> mapDepositTransactionEntities(List<DepositTransactionEntity> entities) {
    logger.debug("Mapping {} DepositTransactionEntity records to DepositTransaction response objects", 
            (entities != null ? entities.size() : 0));

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

    logger.debug("Successfully mapped {} DepositTransaction response objects", responseList.size());
    return responseList;
}

	private List<EquityHolder> mapEquityHolderEntities(List<EquityHolderEntity> entities) {
    logger.debug("Mapping {} EquityHolderEntity records to EquityHolder response objects", 
            (entities != null ? entities.size() : 0));

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

    logger.debug("Successfully mapped {} EquityHolder response objects", responseList.size());
    return responseList;
}

	
private List<EquitySummary> mapEquitySummaryEntities(List<EquitySummaryEntity> entities) {
    logger.debug("Mapping {} EquitySummaryEntity records to EquitySummary response objects",
            (entities != null ? entities.size() : 0));

    List<EquitySummary> responseList = new ArrayList<>();
    for (EquitySummaryEntity entity : entities) {
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

    logger.debug("Successfully mapped {} EquitySummary response objects", responseList.size());
    return responseList;
}

	private List<EquityTransaction> mapEquityTransactionEntities(List<EquityTransactionEntity> entities) {
    logger.debug("Mapping {} EquityTransactionEntity records to EquityTransaction response objects",
            (entities != null ? entities.size() : 0));

    List<EquityTransaction> responseList = new ArrayList<>();
    for (EquityTransactionEntity entity : entities) {
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

    logger.debug("Successfully mapped {} EquityTransaction response objects", responseList.size());
    return responseList;
}


	private List<MFHolder> mapMFHolderEntities(List<MFHolderEntity> entities) {
    logger.debug("Mapping {} MFHolderEntity records to MFHolder response objects",
            (entities != null ? entities.size() : 0));

    List<MFHolder> responseList = new ArrayList<>();
    for (MFHolderEntity entity : entities) {
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

    logger.debug("Successfully mapped {} MFHolder response objects", responseList.size());
    return responseList;
}


	private List<MFSummary> mapMFSummaryEntities(List<MFSummaryEntity> entities) {
    logger.debug("Mapping {} MFSummaryEntity records to MFSummary response objects",
            (entities != null ? entities.size() : 0));

    List<MFSummary> responseList = new ArrayList<>();
    for (MFSummaryEntity entity : entities) {
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

    logger.debug("Successfully mapped {} MFSummary response objects", responseList.size());
    return responseList;
}

	private List<MFTransaction> mapMFTransactionEntities(List<MFTransactionEntity> entities) {
    logger.debug("Mapping {} MFTransactionEntity records to MFTransaction response objects",
            (entities != null ? entities.size() : 0));

    List<MFTransaction> responseList = new ArrayList<>();
    for (MFTransactionEntity entity : entities) {
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

    logger.debug("Successfully mapped {} MFTransaction response objects", responseList.size());
    return responseList;
}

	private List<DepositHolderEntity> mapDepositHolderResponses(List<DepositHolder> responses) {
    logger.debug("Mapping {} DepositHolder responses to DepositHolderEntity objects",
            (responses != null ? responses.size() : 0));

    List<DepositHolderEntity> entityList = new ArrayList<>();
    for (DepositHolder response : responses) {
        DepositHolderEntity entity = new DepositHolderEntity();
        entity.setType(response.getType());
        entity.setAddress(response.getAddress());
        entity.setCkycCompliance(response.getCkycCompliance());
        entity.setDob(response.getDob());
        entity.setEmail(response.getEmail());
        entity.setLandline(response.getLandline());
        entity.setMobile(response.getMobile());
        entity.setName(response.getName());
        entity.setNominee(response.getNominee());
        entity.setPan(response.getPan());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} DepositHolderEntity objects", entityList.size());
    return entityList;
}

private List<DepositSummaryEntity> mapDepositSummaryResponses(List<DepositSummary> responses) {
    logger.debug("Mapping {} DepositSummary responses to DepositSummaryEntity objects",
            (responses != null ? responses.size() : 0));

    List<DepositSummaryEntity> entityList = new ArrayList<>();
    for (DepositSummary response : responses) {
        DepositSummaryEntity entity = new DepositSummaryEntity();
        entity.setBalanceDatetime(response.getBalanceDatetime());
        entity.setBranch(response.getBranch());
        entity.setCurrency(response.getCurrency());
        entity.setCurrentBalance(response.getCurrentBalance());
        entity.setCurrentODLimit(response.getCurrentODLimit());
        entity.setDrawingLimit(response.getDrawingLimit());
        entity.setExchangeRate(response.getExchangeRate());
        entity.setFacility(response.getFacility());
        entity.setIfscCode(response.getIfscCode());
        entity.setMicrCode(response.getMicrCode());
        entity.setOpeningDate(response.getOpeningDate());
        entity.setStatus(response.getStatus());
        entity.setType(response.getType());
        entity.setTransactionType(response.getTransactionType());
        entity.setAmount(response.getAmount());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} DepositSummaryEntity objects", entityList.size());
    return entityList;
}

private List<DepositTransactionEntity> mapDepositTransactionResponses(List<DepositTransaction> responses) {
    logger.debug("Mapping {} DepositTransaction responses to DepositTransactionEntity objects",
            (responses != null ? responses.size() : 0));

    List<DepositTransactionEntity> entityList = new ArrayList<>();
    for (DepositTransaction response : responses) {
        DepositTransactionEntity entity = new DepositTransactionEntity();
        entity.setAmount(response.getAmount());
        entity.setCurrentBalance(response.getCurrentBalance());
        entity.setMode(response.getMode());
        entity.setNarration(response.getNarration());
        entity.setReference(response.getReference());
        entity.setTransactionId(response.getTransactionId());
        entity.setTransactionTimestamp(response.getTransactionTimestamp());
        entity.setType(response.getType());
        entity.setValueDate(response.getValueDate());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} DepositTransactionEntity objects", entityList.size());
    return entityList;
}

private List<EquityHolderEntity> mapEquityHolderResponses(List<EquityHolder> responses) {
    logger.debug("Mapping {} EquityHolder responses to EquityHolderEntity objects",
            (responses != null ? responses.size() : 0));

    List<EquityHolderEntity> entityList = new ArrayList<>();
    for (EquityHolder response : responses) {
        EquityHolderEntity entity = new EquityHolderEntity();
        entity.setAddress(response.getAddress());
        entity.setDematId(response.getDematId());
        entity.setDob(response.getDob());
        entity.setEmail(response.getEmail());
        entity.setKycCompliance(response.getKycCompliance());
        entity.setLandline(response.getLandline());
        entity.setMobile(response.getMobile());
        entity.setName(response.getName());
        entity.setNominee(response.getNominee());
        entity.setPan(response.getPan());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} EquityHolderEntity objects", entityList.size());
    return entityList;
}

private List<EquitySummaryEntity> mapEquitySummaryResponses(List<EquitySummary> responses) {
    logger.debug("Mapping {} EquitySummary responses to EquitySummaryEntity objects",
            (responses != null ? responses.size() : 0));

    List<EquitySummaryEntity> entityList = new ArrayList<>();
    for (EquitySummary response : responses) {
        EquitySummaryEntity entity = new EquitySummaryEntity();
        entity.setCurrentValue(response.getCurrentValue());
        entity.setHoldingMode(response.getHoldingMode());
        entity.setIsin(response.getIsin());
        entity.setIsinDescription(response.getIsinDescription());
        entity.setIssuerName(response.getIssuerName());
        entity.setLastTradedPrice(response.getLastTradedPrice());
        entity.setUnits(response.getUnits());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} EquitySummaryEntity objects", entityList.size());
    return entityList;
}

private List<EquityTransactionEntity> mapEquityTransactionResponses(List<EquityTransaction> responses) {
    logger.debug("Mapping {} EquityTransaction responses to EquityTransactionEntity objects",
            (responses != null ? responses.size() : 0));

    List<EquityTransactionEntity> entityList = new ArrayList<>();
    for (EquityTransaction response : responses) {
        EquityTransactionEntity entity = new EquityTransactionEntity();
        entity.setCompanyName(response.getCompanyName());
        entity.setEquityCategory(response.getEquityCategory());
        entity.setExchange(response.getExchange());
        entity.setIsin(response.getIsin());
        entity.setIsinDescription(response.getIsinDescription());
        entity.setNarration(response.getNarration());
        entity.setOrderId(response.getOrderId());
        entity.setRate(response.getRate());
        entity.setTransactionDateTime(response.getTransactionDateTime());
        entity.setTxnId(response.getTxnId());
        entity.setType(response.getType());
        entity.setUnits(response.getUnits());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} EquityTransactionEntity objects", entityList.size());
    return entityList;
}

private List<MFHolderEntity> mapMFHolderResponses(List<MFHolder> responses) {
    logger.debug("Mapping {} MFHolder responses to MFHolderEntity objects",
            (responses != null ? responses.size() : 0));

    List<MFHolderEntity> entityList = new ArrayList<>();
    for (MFHolder response : responses) {
        MFHolderEntity entity = new MFHolderEntity();
        entity.setAddress(response.getAddress());
        entity.setDematId(response.getDematId());
        entity.setDob(response.getDob());
        entity.setEmail(response.getEmail());
        entity.setFolioNo(response.getFolioNo());
        entity.setKycCompliance(response.getKycCompliance());
        entity.setLandline(response.getLandline());
        entity.setMobile(response.getMobile());
        entity.setName(response.getName());
        entity.setNominee(response.getNominee());
        entity.setPan(response.getPan());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} MFHolderEntity objects", entityList.size());
    return entityList;
}

private List<MFSummaryEntity> mapMFSummaryResponses(List<MFSummary> responses) {
    logger.debug("Mapping {} MFSummary responses to MFSummaryEntity objects",
            (responses != null ? responses.size() : 0));

    List<MFSummaryEntity> entityList = new ArrayList<>();
    for (MFSummary response : responses) {
        MFSummaryEntity entity = new MFSummaryEntity();
        entity.setCostValue(response.getCostValue());
        entity.setCurrentValue(response.getCurrentValue());
        entity.setFatcaStatus(response.getFatcaStatus());
        entity.setAmc(response.getAmc());
        entity.setAmfiCode(response.getAmfiCode());
        entity.setClosingUnits(response.getClosingUnits());
        entity.setFolioNo(response.getFolioNo());
        entity.setIsin(response.getIsin());
        entity.setIsinDescription(response.getIsinDescription());
        entity.setLienUnits(response.getLienUnits());
        entity.setLockinUnits(response.getLockinUnits());
        entity.setNav(response.getNav());
        entity.setNavDate(response.getNavDate());
        entity.setRegistrar(response.getRegistrar());
        entity.setSchemeCategory(response.getSchemeCategory());
        entity.setSchemeCode(response.getSchemeCode());
        entity.setSchemeOption(response.getSchemeOption());
        entity.setSchemeTypes(response.getSchemeTypes());
        entity.setUcc(response.getUcc());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} MFSummaryEntity objects", entityList.size());
    return entityList;
}

private List<MFTransactionEntity> mapMFTransactionResponses(List<MFTransaction> responses) {
    logger.debug("Mapping {} MFTransaction responses to MFTransactionEntity objects",
            (responses != null ? responses.size() : 0));

    List<MFTransactionEntity> entityList = new ArrayList<>();
    for (MFTransaction response : responses) {
        MFTransactionEntity entity = new MFTransactionEntity();
        entity.setAmc(response.getAmc());
        entity.setAmfiCode(response.getAmfiCode());
        entity.setAmount(response.getAmount());
        entity.setIsin(response.getIsin());
        entity.setIsinDescription(response.getIsinDescription());
        entity.setLockInDays(response.getLockInDays());
        entity.setLockInFlag(response.getLockInFlag());
        entity.setMode(response.getMode());
        entity.setNarration(response.getNarration());
        entity.setNav(response.getNav());
        entity.setNavDate(response.getNavDate());
        entity.setRegistrar(response.getRegistrar());
        entity.setSchemeCode(response.getSchemeCode());
        entity.setSchemePlan(response.getSchemePlan());
        entity.setTransactionDate(response.getTransactionDate());
        entity.setTxnId(response.getTxnId());
        entity.setType(response.getType());
        entity.setUcc(response.getUcc());
        entity.setUnits(response.getUnits());
        entityList.add(entity);
    }

    logger.debug("Successfully mapped {} MFTransactionEntity objects", entityList.size());
    return entityList;
}


}
