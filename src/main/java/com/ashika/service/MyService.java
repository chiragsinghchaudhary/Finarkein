package com.ashika.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashika.Constants;
import com.ashika.data.request.ConsentNewRunRequest;
import com.ashika.data.request.GetRequest;
import com.ashika.data.request.RecurringNewRunRequest;
import com.ashika.data.response.BaseResponse;
import com.ashika.data.response.ConsentNewRunResponse;
import com.ashika.data.response.DataDictionary;
import com.ashika.data.response.DepositHolder;
import com.ashika.data.response.DepositSummary;
import com.ashika.data.response.DepositTransaction;
import com.ashika.data.response.EquityHolder;
import com.ashika.data.response.EquitySummary;
import com.ashika.data.response.EquityTransaction;
import com.ashika.data.response.GetResultResponse;
import com.ashika.data.response.GetStatusResponse;
import com.ashika.data.response.MFHolder;
import com.ashika.data.response.MFSummary;
import com.ashika.data.response.MFTransaction;
import com.ashika.data.response.RecurringNewRunResponse;
import com.ashika.entities.ClientConsentMappingEntity;
import com.ashika.entities.DepositHolderEntity;
import com.ashika.entities.DepositSummaryEntity;
import com.ashika.entities.DepositTransactionEntity;
import com.ashika.entities.EquityHolderEntity;
import com.ashika.entities.EquitySummaryEntity;
import com.ashika.entities.EquityTransactionEntity;
import com.ashika.entities.MFHolderEntity;
import com.ashika.entities.MFSummaryEntity;
import com.ashika.entities.MFTransactionEntity;
import com.ashika.repositories.ClientConsentMappingRepository;
import com.ashika.repositories.DepositHolderRepository;
import com.ashika.repositories.DepositSummaryRepository;
import com.ashika.repositories.DepositTransactionRepository;
import com.ashika.repositories.EquityHolderRepository;
import com.ashika.repositories.EquitySummaryRepository;
import com.ashika.repositories.EquityTransactionRepository;
import com.ashika.repositories.MFHolderRepository;
import com.ashika.repositories.MFSummaryRepository;
import com.ashika.repositories.MFTransactionRepository;

@Service
@Transactional
public class MyService {

	private static final Logger logger = LoggerFactory.getLogger(MyService.class);

	@Autowired
	private DepositHolderRepository depositHolderRepository;
	@Autowired
	private DepositSummaryRepository depositSummaryRepository;
	@Autowired
	private DepositTransactionRepository depositTransactionRepository;
	@Autowired
	private EquityHolderRepository equityHolderRepository;
	@Autowired
	private EquitySummaryRepository equitySummaryRepository;
	@Autowired
	private EquityTransactionRepository equityTransactionRepository;
	@Autowired
	private MFHolderRepository mfHolderRepository;
	@Autowired
	private MFSummaryRepository mfSummaryRepository;
	@Autowired
	private MFTransactionRepository mfTransactionRepository;
	@Autowired
	private ClientConsentMappingRepository clientConsentRepository;
	@Autowired
	private FinarkeinClient finarkeinClient;

	public MyService() {
		logger.debug("MyService initialized");
	}

	@Transactional
	public BaseResponse checkValidConsent(GetRequest getRequest) {
		String pan = getRequest.getPan();
		long start = System.currentTimeMillis();

		logger.info("checkValidConsent started -> pan={}", pan);

		Optional<ClientConsentMappingEntity> optionalClientConsentMapping = clientConsentRepository.findTopByPanAndRunTypeAndStateAndConsentStatusAndDataFetchStatusOrderByLastUpdatedTimeDesc(pan,
		  Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE, Constants.SUCCESS);

		ClientConsentMappingEntity entity = null;

		if (optionalClientConsentMapping.isPresent()) {
			entity = optionalClientConsentMapping.get();
		} else {
			logger.warn("No consent mapping found in DB -> pan={}", pan);
			// API gave result, but DB mapping missing
		}

		long duration = System.currentTimeMillis() - start;
		logger.info("checkValidConsent completed -> pan={} | duration={} ms", pan, duration);

		// Build response
		BaseResponse baseResponse = new BaseResponse();

		if (entity != null) {
			logger.debug("Consent record found -> state={} | consentStatus={}", entity.getState(),
					entity.getConsentStatus());

			if (entity.getState().equals(Constants.SUCCESS) && entity.getConsentStatus().equals(Constants.ACTIVE)) {
				logger.info("Consent is VALID -> pan={}", pan);
				baseResponse.setSuccess(true);
			} else {
				logger.warn("Consent is NOT valid -> pan={}", pan);
				baseResponse.setSuccess(false);
				baseResponse.setErrorMessage("Consent is NOT valid");
			}
		} else {
			logger.warn("No consent record found -> pan={}", pan);
			baseResponse.setSuccess(false);
			baseResponse.setErrorMessage("No consent record found");
		}
		return baseResponse;
	}

	@Transactional
	public GetResultResponse getDBRecords(GetRequest getRequest) {
		String pan = getRequest.getPan();
		long startTime = System.currentTimeMillis();

		logger.info("getDBRecords started -> pan={}", pan);

		List<String> idList = new ArrayList<>();
		idList.add(pan);

		// Fetch all data
		List<DepositHolderEntity> depositHolderEntities = depositHolderRepository.findAllByPan(pan);
		List<DepositSummaryEntity> depositSummaries = depositSummaryRepository.findAllByPan(pan);
		List<DepositTransactionEntity> depositTransactions = depositTransactionRepository.findAllByPan(pan);

		List<EquityHolderEntity> equityHolders = equityHolderRepository.findAllByPan(pan);
		List<EquitySummaryEntity> equitySummaries = equitySummaryRepository.findAllByPan(pan);
		List<EquityTransactionEntity> equityTransactions = equityTransactionRepository.findAllByPan(pan);

		List<MFHolderEntity> mfHolders = mfHolderRepository.findAllByPan(pan);
		List<MFSummaryEntity> mfSummaries = mfSummaryRepository.findAllByPan(pan);
		List<MFTransactionEntity> mfTransactions = mfTransactionRepository.findAllByPan(pan);

		// Combined debug log
		logger.debug(
				"Fetched DB records -> DepositHolder={} | DepositSummary={} | DepositTransaction={} | EquityHolder={} | EquitySummary={} | EquityTransaction={} | MFHolder={} | MFSummary={} | MFTransaction={}",
				depositHolderEntities.size(), depositSummaries.size(), depositTransactions.size(), equityHolders.size(),
				equitySummaries.size(), equityTransactions.size(), mfHolders.size(), mfSummaries.size(),
				mfTransactions.size());

		// Build response
		GetResultResponse getResultResponse = new GetResultResponse();

		DataDictionary dataDictionary = new DataDictionary();

		dataDictionary.setDepositHolders(mapDepositHolderEntities(depositHolderEntities));
		dataDictionary.setDepositSummary(mapDepositSummaryEntities(depositSummaries));
		dataDictionary.setDepositTransactions(mapDepositTransactionEntities(depositTransactions));

		dataDictionary.setEquityHolders(mapEquityHolderEntities(equityHolders));
		dataDictionary.setEquitySummary(mapEquitySummaryEntities(equitySummaries));
		dataDictionary.setEquityTransactions(mapEquityTransactionEntities(equityTransactions));

		dataDictionary.setMFHolders(mapMFHolderEntities(mfHolders));
		dataDictionary.setMFSummary(mapMFSummaryEntities(mfSummaries));
		dataDictionary.setMFTransactions(mapMFTransactionEntities(mfTransactions));

		getResultResponse.setData(dataDictionary);

		long duration = System.currentTimeMillis() - startTime;
		logger.info("getDBRecords completed -> pan={} | duration={} ms", pan, duration);

		return getResultResponse;
	}

	@Transactional
	public ConsentNewRunResponse createNewRun(ConsentNewRunRequest consentNewRunRequest) {

		String pan = consentNewRunRequest.getIdentifiers().getPan();
		long overallStart = System.currentTimeMillis();

		logger.info("createNewRun started -> pan={} ", pan);

		// --- API Call ---
		long apiStart = System.currentTimeMillis();
		logger.info("API call: createNewConsentRun -> pan={}", pan);

		ConsentNewRunResponse consentResponse = finarkeinClient.createNewConsentRun(consentNewRunRequest);

		logger.info("API call completed: createNewConsentRun -> pan={} | duration={} ms", pan,
				System.currentTimeMillis() - apiStart);

		logger.debug("ConsentNewRun API Response -> requestId={} | consentHandle={}", consentResponse.getRequestId(),
				consentResponse.getConsentHandle());

		// --- DB Save ---

		LocalDate dob = null;
		try {
			dob = LocalDate.parse(consentNewRunRequest.getIdentifiers().getDob());
		} catch (Exception e) {
			logger.warn("Invalid DOB format in request for clientUserId={} | value={}",
					consentNewRunRequest.getApplicationNo(), consentNewRunRequest.getIdentifiers().getDob());
		}

		ClientConsentMappingEntity entity = new ClientConsentMappingEntity();
		
		entity.setPan(consentNewRunRequest.getIdentifiers().getPan());
		entity.setRequestId(consentResponse.getRequestId());
		entity.setClientCode(consentNewRunRequest.getApplicationNo());
		entity.setRunType(Constants.CONSENT);
		entity.setDob(dob);
		entity.setConsentHandle(consentResponse.getConsentHandle());
		entity.setLastUpdatedTime(LocalDateTime.now());

		long dbStart = System.currentTimeMillis();
		logger.info("DB save started -> pan={} | requestId={}", entity.getPan(), entity.getRequestId());
		
		ClientConsentMappingEntity savedEntity = clientConsentRepository.save(entity);
		
		logger.info("DB save completed -> pan={} | requestId={} | duration={} ms", entity.getPan(),
				entity.getRequestId(), System.currentTimeMillis() - dbStart);

		// --- Completion ---
		logger.info("createNewRun completed -> pan={} | totalDuration={} ms", pan,
				System.currentTimeMillis() - overallStart);

		return consentResponse;
	}

	@Modifying
	@Transactional
	public RecurringNewRunResponse createNewRunFetch(GetRequest getRequest) {

		String pan = getRequest.getPan();
		long overallStart = System.currentTimeMillis();

		logger.info("createNewRunFetch started -> pan={} ", pan);

		// --- DB Fetch ---
		long dbFetchStart = System.currentTimeMillis();
		logger.info("DB fetch latest consent object -> pan={}", pan);

		Optional<ClientConsentMappingEntity> optionalClientConsentMapping = clientConsentRepository.findTopByPanAndRunTypeAndStateAndConsentStatusAndDataFetchStatusOrderByLastUpdatedTimeDesc(pan,
				  Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE, Constants.SUCCESS);

		ClientConsentMappingEntity clientConsentMappingEntity = null;

		if (optionalClientConsentMapping.isPresent()) {
			clientConsentMappingEntity = optionalClientConsentMapping.get();
		} else {
			logger.warn("No consent mapping found in DB -> pan={}", pan);
			// API gave result, but DB mapping missing
		}
		
		if (clientConsentMappingEntity == null) {
			logger.warn("No consent mapping found -> pan={} | Aborting createNewRunFetch", pan);
			return null; // Or throw custom exception
		}

		logger.info("DB fetch completed -> pan={} | consentHandle={} |duration={} ms", pan, clientConsentMappingEntity.getConsentHandle(), System.currentTimeMillis() - dbFetchStart);

		logger.debug("Fetched consentHandle={} for pan={}", clientConsentMappingEntity.getConsentHandle(), pan);

		// --- API Call ---
		RecurringNewRunRequest recurringNewRunRequest = new RecurringNewRunRequest();

		recurringNewRunRequest.setConsentHandle(clientConsentMappingEntity.getConsentHandle());

		long apiStart = System.currentTimeMillis();
		logger.info("API call: createNewRecurringRun -> pan={}", pan);

		RecurringNewRunResponse recurringResponse = finarkeinClient.createNewRecurringRun(recurringNewRunRequest);

		logger.info("API call completed: createNewRecurringRun -> pan={} | duration={} ms", pan,
				System.currentTimeMillis() - apiStart);

		logger.debug("RecurringNewRun API Response -> requestId={}", recurringResponse.getRequestId());

		// --- DB Save ---

		ClientConsentMappingEntity entity = new ClientConsentMappingEntity();
		entity.setPan(clientConsentMappingEntity.getPan());
		entity.setRequestId(recurringResponse.getRequestId());
		entity.setClientCode(clientConsentMappingEntity.getClientCode());
		entity.setRunType(Constants.RECURRING);
		entity.setDob(clientConsentMappingEntity.getDob());
		entity.setConsentHandle(clientConsentMappingEntity.getConsentHandle());
		entity.setLastUpdatedTime(LocalDateTime.now());

		long dbSaveStart = System.currentTimeMillis();
		logger.info("DB save recurring run -> pan={} | requestId={}", entity.getPan(), entity.getRequestId());

		clientConsentRepository.saveAndFlush(entity);

		logger.info("DB save completed -> pan={} | requestId={} | duration={} ms", entity.getPan(),
				entity.getRequestId(), System.currentTimeMillis() - dbSaveStart);

		// --- Completion ---
		logger.info("createNewRunFetch completed -> pan={} | totalDuration={} ms", pan,
				System.currentTimeMillis() - overallStart);

		return recurringResponse;
	}

	public GetStatusResponse getStatus(String requestId) {

		long overallStart = System.currentTimeMillis();
		logger.info("getStatus started -> requestId={}", requestId);

		// --- API Call ---
		long apiStart = System.currentTimeMillis();
		logger.info("API call: getStatus -> requestId={}", requestId);

		GetStatusResponse statusResponse = finarkeinClient.getStatus(requestId);

		if (statusResponse == null || statusResponse.getState() == null) {
			logger.error("API getStatus returned null or invalid state -> requestId={}", requestId);
			return null; // Or throw custom exception
		}

		logger.info("API call completed: getStatus -> requestId={} | duration={} ms", requestId,
				System.currentTimeMillis() - apiStart);

		logger.info("Status API Response -> state={} | consentStatus={} | dataFetchStatus={}",
				statusResponse.getState().getState(), statusResponse.getState().getConsentStatus(),
				statusResponse.getState().getDataFetchStatus());

		// --- DB Update ---
		long dbStart = System.currentTimeMillis();
		logger.info("DB updateStatus -> requestId={}", requestId);

		Optional<ClientConsentMappingEntity> optionalClientConsentMapping = clientConsentRepository
				.findByRequestId(requestId);

		ClientConsentMappingEntity clientConsentMappingEntity = null;

		if (optionalClientConsentMapping.isPresent()) {
			clientConsentMappingEntity = optionalClientConsentMapping.get();
			clientConsentMappingEntity.setState(statusResponse.getState().getState());
			clientConsentMappingEntity.setConsentStatus(statusResponse.getState().getConsentStatus());
			clientConsentMappingEntity.setConsentStatus(statusResponse.getState().getConsentStatus());
			clientConsentMappingEntity.setDataFetchStatus(statusResponse.getState().getDataFetchStatus());
		}

		clientConsentRepository.saveAndFlush(clientConsentMappingEntity);

		logger.info("DB updateStatus completed -> requestId={} | duration={} ms", requestId,
				System.currentTimeMillis() - dbStart);

		// --- Completion ---
		logger.info("getStatus completed -> requestId={} | totalDuration={} ms", requestId,
				System.currentTimeMillis() - overallStart);

		return statusResponse;
	}

	@Transactional
	public GetResultResponse getResult(String requestId) {

		long overallStart = System.currentTimeMillis();
		logger.info("getResult started -> requestId={}", requestId);

		// --- API Call ---
		long apiStart = System.currentTimeMillis();
		logger.info("API call: getResult -> requestId={}", requestId);

		GetResultResponse resultResponse = finarkeinClient.getResult(requestId);

		if (resultResponse == null || resultResponse.getState() == null) {
			logger.error("API getResult returned null or invalid state -> requestId={}", requestId);
			return null; // Or throw custom exception
		}

		logger.info("API call completed: getResult -> requestId={} | duration={} ms", requestId,
				System.currentTimeMillis() - apiStart);

		logger.debug("Fetched result -> dataFetchStatus={}", resultResponse.getState().getDataFetchStatus());

		// --- DB Fetch Consent Mapping ---
		long dbFetchStart = System.currentTimeMillis();
		logger.info("DB fetch by referenceId -> requestId={}", requestId);

		Optional<ClientConsentMappingEntity> optionalClientConsentMapping = clientConsentRepository
				.findByRequestId(requestId);

		ClientConsentMappingEntity clientConsentMappingEntity = null;

		if (optionalClientConsentMapping.isPresent()) {
			clientConsentMappingEntity = optionalClientConsentMapping.get();
		} else {
			logger.warn("No consent mapping found in DB -> requestId={}", requestId);
			return resultResponse; // API gave result, but DB mapping missing
		}

		logger.info("DB fetch completed -> requestId={} | duration={} ms", requestId,
				System.currentTimeMillis() - dbFetchStart);

		// --- Data Save Logic ---
		String pan = clientConsentMappingEntity.getPan();

		if (Constants.SUCCESS.equals(resultResponse.getState().getDataFetchStatus())) {
			long dbSaveStart = System.currentTimeMillis();
			logger.info("DB replace operation started -> pan={}", pan);

			// Delete old records
			depositHolderRepository.deleteAllByPan(pan);
			depositSummaryRepository.deleteAllByPan(pan);
			depositTransactionRepository.deleteAllByPan(pan);
			equityHolderRepository.deleteAllByPan(pan);
			equitySummaryRepository.deleteAllByPan(pan);
			equityTransactionRepository.deleteAllByPan(pan);
			mfHolderRepository.deleteAllByPan(pan);
			mfSummaryRepository.deleteAllByPan(pan);
			mfTransactionRepository.deleteAllByPan(pan);
			
			
			logger.debug("Deleted existing records for pan={}", pan);

			// Save new records
			depositHolderRepository
					.saveAllAndFlush(mapDepositHolderResponses(resultResponse.getData().getDepositHolders()));
			depositSummaryRepository
					.saveAllAndFlush(mapDepositSummaryResponses(resultResponse.getData().getDepositSummary(), pan));
			depositTransactionRepository.saveAllAndFlush(
					mapDepositTransactionResponses(resultResponse.getData().getDepositTransactions(), pan));

			equityHolderRepository
					.saveAllAndFlush(mapEquityHolderResponses(resultResponse.getData().getEquityHolders()));
			equitySummaryRepository
					.saveAllAndFlush(mapEquitySummaryResponses(resultResponse.getData().getEquitySummary(), pan));
			equityTransactionRepository.saveAllAndFlush(
					mapEquityTransactionResponses(resultResponse.getData().getEquityTransactions(), pan));
			mfHolderRepository.saveAllAndFlush(mapMFHolderResponses(resultResponse.getData().getMFHolders()));
			mfSummaryRepository.saveAllAndFlush(mapMFSummaryResponses(resultResponse.getData().getMFSummary(), pan));
			mfTransactionRepository
					.saveAllAndFlush(mapMFTransactionResponses(resultResponse.getData().getMFTransactions(), pan));

			logger.debug("Saved new records for pan={}", pan);

			logger.info("DB replace operation completed -> pan={} | duration={} ms", pan,
					System.currentTimeMillis() - dbSaveStart);

		} else {
			logger.warn("Data fetch status is NOT SUCCESS -> requestId={} | status={}", requestId,
					resultResponse.getState().getDataFetchStatus());
		}

		logger.info("getResult completed -> requestId={} | totalDuration={} ms", requestId,
				System.currentTimeMillis() - overallStart);

		return resultResponse;
	}

	private List<DepositHolder> mapDepositHolderEntities(List<DepositHolderEntity> entities) {
		if (entities == null || entities.isEmpty()) {
			logger.debug("No DepositHolderEntity records found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} DepositHolderEntity records to DepositHolder response objects", entities.size());

		List<DepositHolder> responseList = new ArrayList<>(entities.size());
		for (DepositHolderEntity entity : entities) {
			DepositHolder response = new DepositHolder();
			response.setName(entity.getName());
			response.setEmail(entity.getEmail());
			response.setDob(entity.getDob());
			response.setMaskedAccNumber(entity.getMaskedAccNumber());
			response.setAccountType(entity.getAccountType());
			response.setLandLine(entity.getLandLine());
			response.setAddress(entity.getAddress());
			response.setCkycCompliance(entity.getCkycCompliance());
			response.setLinkedAccRef(entity.getLinkedAccRef());
			response.setType(entity.getType());
			response.setMobile(entity.getMobile());
			response.setPan(entity.getPan());
			response.setNominee(entity.getNominee());

			// Add to list
			responseList.add(response);
		}

		logger.debug("Mapped {} DepositHolderEntity records to DepositHolder response objects", responseList.size());
		return responseList;
	}

	private List<DepositSummary> mapDepositSummaryEntities(List<DepositSummaryEntity> entities) {
		if (entities == null || entities.isEmpty()) {
			logger.debug("No DepositSummaryEntity records found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} DepositSummaryEntity records to DepositSummary response objects", entities.size());

		List<DepositSummary> responseList = new ArrayList<>(entities.size());
		for (DepositSummaryEntity entity : entities) {
			DepositSummary response = new DepositSummary();
			response.setCurrentODLimit(entity.getCurrentODLimit());
			response.setOpeningDate(entity.getOpeningDate());
			response.setFipName(entity.getFipName());
			response.setMaskedAccNumber(entity.getMaskedAccNumber());
			response.setBranch(entity.getBranch());
			response.setAccountType(entity.getAccountType());
			response.setCurrentBalance(entity.getCurrentBalance());
			response.setDrawingLimit(entity.getDrawingLimit());
			response.setAccountAgeInDays(entity.getAccountAgeInDays());
			response.setPendingTransactionType(entity.getPendingTransactionType());
			response.setStatus(entity.getStatus());
			response.setMicrCode(entity.getMicrCode());
			response.setBalanceDatetime(entity.getBalanceDatetime());
			response.setCurrency(entity.getCurrency());
			response.setPendingAmount(entity.getPendingAmount());
			response.setLinkedAccRef(entity.getLinkedAccRef());
			response.setIfscCode(entity.getIfscCode());
			response.setType(entity.getType());
			response.setFacility(entity.getFacility());
			response.setExchangeRate(entity.getExchangeRate());

			// Add to list
			responseList.add(response);
		}

		logger.debug("Mapped {} DepositSummaryEntity records to DepositSummary response objects", responseList.size());
		return responseList;
	}

	private List<DepositTransaction> mapDepositTransactionEntities(List<DepositTransactionEntity> entities) {
		if (entities == null || entities.isEmpty()) {
			logger.debug("No DepositTransactionEntity records found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} DepositTransactionEntity records to DepositTransaction response objects",
				entities.size());

		List<DepositTransaction> responseList = new ArrayList<>(entities.size());
		for (DepositTransactionEntity entity : entities) {
			DepositTransaction response = new DepositTransaction();
			response.setReference(entity.getReference());
			response.setTxnId(entity.getTransactionId());
			response.setMaskedAccNumber(entity.getMaskedAccNumber());
			response.setTransactionTimestamp(entity.getTransactionTimestamp());
			response.setAccountType(entity.getAccountType());
			response.setCurrentBalance(entity.getCurrentBalance());
			response.setAmount(entity.getAmount());
			response.setValueDate(entity.getValueDate());
			response.setNarration(entity.getNarration());
			response.setMode(entity.getMode());
			response.setLinkedAccRef(entity.getLinkedAccRef());
			response.setType(entity.getType());

			// Add to list
			responseList.add(response);
		}

		logger.debug("Mapped {} DepositTransactionEntity records to DepositTransaction response objects",
				responseList.size());
		return responseList;
	}

private List<EquityHolder> mapEquityHolderEntities(List<EquityHolderEntity> entities) {
    if (entities == null || entities.isEmpty()) {
        logger.debug("No EquityHolderEntity records found to map.");
        return new ArrayList<>();
    }

    logger.debug("Mapping {} EquityHolderEntity records to EquityHolder response objects", entities.size());

    List<EquityHolder> responseList = new ArrayList<>(entities.size());
    for (EquityHolderEntity entity : entities) {
        EquityHolder response = new EquityHolder();

        // Following the specified JSON order
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        response.setDob(entity.getDob());
        response.setMaskedAccNumber(entity.getMaskedAccNumber());
        response.setFolioNo(entity.getFolioNo());
        response.setAccountType(entity.getAccountType());
        response.setLandline(entity.getLandline());
        response.setDematId(entity.getDematId());
        response.setAddress(entity.getAddress());
        response.setKycCompliance(entity.getKycCompliance());
        response.setLinkedAccRef(entity.getLinkedAccRef());
        response.setMobile(entity.getMobile());
        response.setPan(entity.getPan());
        response.setNominee(entity.getNominee());

        responseList.add(response);
    }

    logger.debug("Successfully mapped {} EquityHolder response objects", responseList.size());
    return responseList;
}

private List<EquitySummary> mapEquitySummaryEntities(List<EquitySummaryEntity> entities) {
    if (entities == null || entities.isEmpty()) {
        logger.debug("No EquitySummaryEntity records found to map.");
        return new ArrayList<>();
    }

    logger.debug("Mapping {} EquitySummaryEntity records to EquitySummary response objects", entities.size());

    List<EquitySummary> responseList = new ArrayList<>(entities.size());
    for (EquitySummaryEntity entity : entities) {
        EquitySummary response = new EquitySummary();

        // Matching the specified JSON order
        response.setLastTradedPrice(entity.getLastTradedPrice());
        response.setMaskedAccNumber(entity.getMaskedAccNumber());
        response.setIsin(entity.getIsin());
        response.setIsinDescription(entity.getIsinDescription());
        response.setAccountType(entity.getAccountType());
        response.setUnits(entity.getUnits());
        response.setLinkedAccRef(entity.getLinkedAccRef());
        response.setType(entity.getType());
        response.setCurrentValue(entity.getCurrentValue());
        response.setIssuerName(entity.getIssuerName());

        responseList.add(response);
    }

    logger.debug("Successfully mapped {} EquitySummary response objects", responseList.size());
    return responseList;
}

private List<EquityTransaction> mapEquityTransactionEntities(List<EquityTransactionEntity> entities) {
    if (entities == null || entities.isEmpty()) {
        logger.debug("No EquityTransactionEntity records found to map.");
        return new ArrayList<>();
    }

    logger.debug("Mapping {} EquityTransactionEntity records to EquityTransaction response objects",
            entities.size());

    List<EquityTransaction> responseList = new ArrayList<>(entities.size());
    for (EquityTransactionEntity entity : entities) {
        EquityTransaction response = new EquityTransaction();

        // Matching JSON order
        response.setRate(entity.getRate());
        response.setTxnId(entity.getTxnId());
        response.setTransactionDateTime(entity.getTransactionDateTime());
        response.setOrderId(entity.getOrderId());
        response.setMaskedAccNumber(entity.getMaskedAccNumber());
        response.setIsin(entity.getIsin());
        response.setIsinDescription(entity.getIsinDescription());
        response.setAccountType(entity.getAccountType());
        response.setEquityCategory(entity.getEquityCategory());
        response.setExchange(entity.getExchange());
        response.setCompanyName(entity.getCompanyName());
        response.setNarration(entity.getNarration());
        response.setUnits(entity.getUnits());
        response.setLinkedAccRef(entity.getLinkedAccRef());
        response.setType(entity.getType());

        responseList.add(response);
    }

    logger.debug("Successfully mapped {} EquityTransaction response objects", responseList.size());
    return responseList;
}

	private List<MFHolder> mapMFHolderEntities(List<MFHolderEntity> entities) {
    if (entities == null || entities.isEmpty()) {
        logger.debug("No MFHolderEntity records found to map.");
        return new ArrayList<>();
    }

    logger.debug("Mapping {} MFHolderEntity records to MFHolder response objects", entities.size());

    List<MFHolder> responseList = new ArrayList<>(entities.size());
    for (MFHolderEntity entity : entities) {
        MFHolder response = new MFHolder();

        // Order as per given JSON
        response.setName(entity.getName());
        response.setMaskedDematID(entity.getMaskedDematID());
        response.setEmail(entity.getEmail());
        response.setDob(entity.getDob());
        response.setMaskedAccNumber(entity.getMaskedAccNumber());
        response.setFolioNo(entity.getFolioNo());
        response.setAccountType(entity.getAccountType());
        response.setLandline(entity.getLandline());
        response.setDematId(entity.getDematId());
        response.setAddress(entity.getAddress());
        response.setCkycCompliance(entity.getCkycCompliance());
        response.setLinkedAccRef(entity.getLinkedAccRef());
        response.setMobile(entity.getMobile());
        response.setPan(entity.getPan());
        response.setMaskedFolioNo(entity.getMaskedFolioNo());
        response.setNominee(entity.getNominee());

        responseList.add(response);
    }

    logger.debug("Successfully mapped {} MFHolder response objects", responseList.size());
    return responseList;
}


	private List<MFSummary> mapMFSummaryEntities(List<MFSummaryEntity> entities) {
    if (entities == null || entities.isEmpty()) {
        logger.debug("No MFSummaryEntity records found to map.");
        return new ArrayList<>();
    }

    logger.debug("Mapping {} MFSummaryEntity records to MFSummary response objects", entities.size());

    List<MFSummary> responseList = new ArrayList<>(entities.size());
    for (MFSummaryEntity entity : entities) {
        MFSummary response = new MFSummary();

        // Order as per given JSON
        response.setUcc(entity.getUcc());
        response.setMaskedDematID(entity.getMaskedDematID());
        response.setNav(entity.getNav());
        response.setMaskedAccNumber(entity.getMaskedAccNumber());
        response.setIsin(entity.getIsin());
        response.setIsinDescription(entity.getIsinDescription());
        response.setSchemeCode(entity.getSchemeCode());
        response.setFolioNo(entity.getFolioNo());
        response.setAccountType(entity.getAccountType());
        response.setCostValue(entity.getCostValue());
        response.setClosingUnits(entity.getClosingUnits());
        response.setAmc(entity.getAmc());
        response.setRegistrar(entity.getRegistrar());
        response.setSchemeOption(entity.getSchemeOption());
        response.setSchemeCategory(entity.getSchemeCategory());
        response.setFatcaStatus(entity.getFatcaStatus());
        response.setLienUnits(entity.getLienUnits());
        response.setLockinUnits(entity.getLockinUnits());
        response.setNavDate(entity.getNavDate());
        response.setLinkedAccRef(entity.getLinkedAccRef());
        response.setCurrentValue(entity.getCurrentValue());
        response.setSchemeTypes(entity.getSchemeTypes());
        response.setMaskedFolioNo(entity.getMaskedFolioNo());
        response.setAmfiCode(entity.getAmfiCode());

        responseList.add(response);
    }

    logger.debug("Successfully mapped {} MFSummary response objects", responseList.size());
    return responseList;
}

	private List<MFTransaction> mapMFTransactionEntities(List<MFTransactionEntity> entities) {
		if (entities == null || entities.isEmpty()) {
			logger.debug("No MFTransactionEntity records found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFTransactionEntity records to MFTransaction response objects", entities.size());

		List<MFTransaction> responseList = new ArrayList<>(entities.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No DepositHolder responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} DepositHolder responses to DepositHolderEntity objects", responses.size());

		List<DepositHolderEntity> entityList = new ArrayList<>(responses.size());
		for (DepositHolder response : responses) {
			DepositHolderEntity entity = new DepositHolderEntity(response.getName(), response.getEmail(),
					response.getDob(), response.getMaskedAccNumber(), response.getAccountType(), response.getLandLine(),
					response.getAddress(), response.getCkycCompliance(), response.getLinkedAccRef(), response.getType(),
					response.getMobile(), response.getPan(), response.getNominee());

			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} DepositHolderEntity objects", entityList.size());
		return entityList;
	}

	private List<DepositSummaryEntity> mapDepositSummaryResponses(List<DepositSummary> responses, String pan) {
		if (responses == null || responses.isEmpty()) {
			logger.debug("No DepositSummary responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} DepositSummary responses to DepositSummaryEntity objects", responses.size());

		List<DepositSummaryEntity> entityList = new ArrayList<>(responses.size());
		for (DepositSummary response : responses) {
			DepositSummaryEntity entity = new DepositSummaryEntity(response.getCurrentODLimit(),
					response.getOpeningDate(), response.getFipName(), response.getMaskedAccNumber(),
					response.getBranch(), response.getAccountType(), response.getCurrentBalance(),
					response.getDrawingLimit(), response.getAccountAgeInDays(), response.getPendingTransactionType(),
					response.getStatus(), response.getMicrCode(), response.getBalanceDatetime(), response.getCurrency(),
					response.getPendingAmount(), response.getLinkedAccRef(), response.getIfscCode(), response.getType(),
					response.getFacility(), response.getExchangeRate(), pan);

			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} DepositSummaryEntity objects", entityList.size());
		return entityList;
	}

	private List<DepositTransactionEntity> mapDepositTransactionResponses(List<DepositTransaction> responses,
			String pan) {
		if (responses == null || responses.isEmpty()) {
			logger.debug("No DepositTransaction responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} DepositTransaction responses to DepositTransactionEntity objects", responses.size());

		List<DepositTransactionEntity> entityList = new ArrayList<>(responses.size());
		for (DepositTransaction response : responses) {
			DepositTransactionEntity entity = new DepositTransactionEntity(pan, response.getReference(),
					response.getTxnId(), response.getMaskedAccNumber(), response.getTransactionTimestamp(),
					response.getAccountType(), response.getCurrentBalance(), response.getAmount(),
					response.getValueDate(), response.getNarration(), response.getMode(), response.getLinkedAccRef(),
					response.getType());

			// Add to list
			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} DepositTransactionEntity objects", entityList.size());
		return entityList;
	}

	private List<EquityHolderEntity> mapEquityHolderResponses(List<EquityHolder> responses) {
		if (responses == null || responses.isEmpty()) {
			logger.debug("No EquityHolder responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} EquityHolder responses to EquityHolderEntity objects", responses.size());

		List<EquityHolderEntity> entityList = new ArrayList<>(responses.size());
		for (EquityHolder response : responses) {
			EquityHolderEntity entity = new EquityHolderEntity(response.getAddress(), response.getDematId(),
					response.getDob(), response.getEmail(), response.getKycCompliance(), response.getLandline(),
					response.getMobile(), response.getName(), response.getNominee(), response.getPan());
			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} EquityHolderEntity objects", entityList.size());
		return entityList;
	}

	private List<EquitySummaryEntity> mapEquitySummaryResponses(List<EquitySummary> responses, String pan) {
		if (responses == null || responses.isEmpty()) {
			logger.debug("No EquitySummary responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} EquitySummary responses to EquitySummaryEntity objects", responses.size());

		List<EquitySummaryEntity> entityList = new ArrayList<>(responses.size());
		for (EquitySummary response : responses) {
			EquitySummaryEntity entity = new EquitySummaryEntity(response.getCurrentValue(), response.getHoldingMode(),
					response.getIsin(), response.getIsinDescription(), response.getIssuerName(),
					response.getLastTradedPrice(), response.getUnits(), pan);

			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} EquitySummaryEntity objects", entityList.size());
		return entityList;
	}

	private List<EquityTransactionEntity> mapEquityTransactionResponses(List<EquityTransaction> responses, String pan) {
		if (responses == null || responses.isEmpty()) {
			logger.debug("No EquityTransaction responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} EquityTransaction responses to EquityTransactionEntity objects", responses.size());

		List<EquityTransactionEntity> entityList = new ArrayList<>(responses.size());
		for (EquityTransaction response : responses) {
			EquityTransactionEntity entity = new EquityTransactionEntity(response.getCompanyName(),
					response.getEquityCategory(), response.getExchange(), response.getIsin(),
					response.getIsinDescription(), response.getNarration(), response.getOrderId(), response.getRate(),
					response.getTransactionDateTime(), response.getTxnId(), response.getType(), response.getUnits(),
					pan);

			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} EquityTransactionEntity objects", entityList.size());
		return entityList;
	}

	private List<MFHolderEntity> mapMFHolderResponses(List<MFHolder> responses) {
		if (responses == null || responses.isEmpty()) {
			logger.debug("No MFHolder responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFHolder responses to MFHolderEntity objects", responses.size());

		List<MFHolderEntity> entityList = new ArrayList<>(responses.size());
		for (MFHolder response : responses) {
			MFHolderEntity entity = new MFHolderEntity(response.getAddress(), response.getDematId(), response.getDob(),
					response.getEmail(), response.getFolioNo(), response.getKycCompliance(), response.getLandline(),
					response.getMobile(), response.getName(), response.getNominee(), response.getPan());

			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} MFHolderEntity objects", entityList.size());
		return entityList;
	}

	private List<MFSummaryEntity> mapMFSummaryResponses(List<MFSummary> responses, String pan) {
		if (responses == null || responses.isEmpty()) {
			logger.debug("No MFSummary responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFSummary responses to MFSummaryEntity objects", responses.size());

		List<MFSummaryEntity> entityList = new ArrayList<>(responses.size());
		for (MFSummary response : responses) {
			MFSummaryEntity entity = new MFSummaryEntity(response.getCostValue(), response.getCurrentValue(),
					response.getFatcaStatus(), response.getAmc(), response.getAmfiCode(), response.getClosingUnits(),
					response.getFolioNo(), response.getIsin(), response.getIsinDescription(), response.getLienUnits(),
					response.getLockinUnits(), response.getNav(), response.getNavDate(), response.getRegistrar(),
					response.getSchemeCategory(), response.getSchemeCode(), response.getSchemeOption(),
					response.getSchemeTypes(), response.getUcc(), pan);

			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} MFSummaryEntity objects", entityList.size());
		return entityList;
	}

	private List<MFTransactionEntity> mapMFTransactionResponses(List<MFTransaction> responses, String pan) {
		if (responses == null || responses.isEmpty()) {
			logger.debug("No MFTransaction responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFTransaction responses to MFTransactionEntity objects", responses.size());

		List<MFTransactionEntity> entityList = new ArrayList<>(responses.size());
		for (MFTransaction response : responses) {
			MFTransactionEntity entity = new MFTransactionEntity(response.getAmc(), response.getAmfiCode(),
					response.getAmount(), response.getIsin(), response.getIsinDescription(), response.getLockInDays(),
					response.getLockInFlag(), response.getMode(), response.getNarration(), response.getNav(),
					response.getNavDate(), response.getRegistrar(), response.getSchemeCode(), response.getSchemePlan(),
					response.getTransactionDate(), response.getTxnId(), response.getType(), response.getUcc(),
					response.getUnits(), pan);

			entityList.add(entity);
		}

		logger.debug("Successfully mapped {} MFTransactionEntity objects", entityList.size());
		return entityList;
	}

}
