package com.ashika.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashika.model.dto.ClientConsentMappingDTO;
import com.ashika.model.entities.ClientConsentMappingEntity;
import com.ashika.model.entities.DepositHolderEntity;
import com.ashika.model.entities.DepositSummaryEntity;
import com.ashika.model.entities.DepositTransactionEntity;
import com.ashika.model.entities.EquityHolderEntity;
import com.ashika.model.entities.EquitySummaryEntity;
import com.ashika.model.entities.EquityTransactionEntity;
import com.ashika.model.entities.MFHolderEntity;
import com.ashika.model.entities.MFSummaryEntity;
import com.ashika.model.entities.MFTransactionEntity;
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
import com.ashikha.Constants;
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
public class MyService {

	private static final Logger logger = LoggerFactory.getLogger(MyService.class);

	private DepositHolderRepository depositHolderRepository;

	private DepositSummaryRepository depositSummaryRepository;
	
	private DepositTransactionRepository depositTransactionRepository;
	
	private EquityHolderRepository equityHolderRepository;
	
	private EquitySummaryRepository equitySummaryRepository;
	
	private EquityTransactionRepository equityTransactionRepository;

	
	private MFHolderRepository mfHolderRepository;
	
	private MFSummaryRepository mfSummaryRepository;
	
	private MFTransactionRepository mfTransactionRepository;

	private ClientConsentMappingRepository clientConsentRepository;

	private FinarkeinClient finarkeinClient = new FinarkeinClient();

	public boolean checkValidConsent(GetRequest getRequest) {
		String pan = getRequest.getPan();
		long start = System.currentTimeMillis();

		logger.info("checkValidConsent started -> pan={}", pan);

		ClientConsentMappingEntity entity = clientConsentRepository.getlatestClientConsentObject(pan, Constants.CONSENT,
				Constants.SUCCESS, Constants.ACTIVE);

		long duration = System.currentTimeMillis() - start;
		logger.info("checkValidConsent completed -> pan={} | duration={} ms", pan, duration);

		if (entity != null) {
			logger.debug("Consent record found -> state={} | consentStatus={}", entity.getState(),
					entity.getConsentStatus());

			if (entity.getState().equals(Constants.SUCCESS) && entity.getConsentStatus().equals(Constants.ACTIVE)) {
				logger.info("Consent is VALID -> pan={}", pan);
				return true;
			} else {
				logger.warn("Consent is NOT valid -> pan={}", pan);
				return false;
			}
		} else {
			logger.warn("No consent record found -> pan={}", pan);
			return false;
		}
	}

	public GetResultResponse getDBRecords(GetRequest getRequest) {
		String pan = getRequest.getPan();
		long startTime = System.currentTimeMillis();

		logger.info("getDBRecords started -> pan={}", pan);

		List<String> idList = new ArrayList<>();
		idList.add(pan);

		// Fetch all data
		List<DepositHolderEntity> depositHolders = depositHolderRepository.findAllById(idList);
		List<DepositSummaryEntity> depositSummaries = depositSummaryRepository.findAllById(idList);
		List<DepositTransactionEntity> depositTransactions = depositTransactionRepository.findAllById(idList);

		List<EquityHolderEntity> equityHolders = equityHolderRepository.findAllById(idList);
		List<EquitySummaryEntity> equitySummaries = equitySummaryRepository.findAllById(idList);
		List<EquityTransactionEntity> equityTransactions = equityTransactionRepository.findAllById(idList);

		List<MFHolderEntity> mfHolders = mfHolderRepository.findAllById(idList);
		List<MFSummaryEntity> mfSummaries = mfSummaryRepository.findAllById(idList);
		List<MFTransactionEntity> mfTransactions = mfTransactionRepository.findAllById(idList);

		// Combined debug log
		logger.debug(
				"Fetched DB records -> DepositHolder={} | DepositSummary={} | DepositTransaction={} | EquityHolder={} | EquitySummary={} | EquityTransaction={} | MFHolder={} | MFSummary={} | MFTransaction={}",
				depositHolders.size(), depositSummaries.size(), depositTransactions.size(), equityHolders.size(),
				equitySummaries.size(), equityTransactions.size(), mfHolders.size(), mfSummaries.size(),
				mfTransactions.size());

		// Build response
		GetResultResponse getResultResponse = new GetResultResponse();

		DepositResponse depositResponse = new DepositResponse();
		depositResponse.setHolder(mapDepositHolderEntities(depositHolders));
		depositResponse.setSummary(mapDepositSummaryEntities(depositSummaries));
		depositResponse.setTransactions(mapDepositTransactionEntities(depositTransactions));

		EquityResponse equityResponse = new EquityResponse();
		equityResponse.setHolder(mapEquityHolderEntities(equityHolders));
		equityResponse.setSummary(mapEquitySummaryEntities(equitySummaries));
		equityResponse.setTransactions(mapEquityTransactionEntities(equityTransactions));

		MFResponse mfResponse = new MFResponse();
		mfResponse.setHolder(mapMFHolderEntities(mfHolders));
		mfResponse.setSummary(mapMFSummaryEntities(mfSummaries));
		mfResponse.setTransactions(mapMFTransactionEntities(mfTransactions));

		DataDictionary dataDictionary = new DataDictionary();
		dataDictionary.setDeposit(depositResponse);
		dataDictionary.setEquity(equityResponse);
		dataDictionary.setMf(mfResponse);

		getResultResponse.setData(dataDictionary);

		long duration = System.currentTimeMillis() - startTime;
		logger.info("getDBRecords completed -> pan={} | duration={} ms", pan, duration);

		return getResultResponse;
	}

	public ConsentNewRunResponse createNewRun(String workspace, String flowId,
			ConsentNewRunRequest consentNewRunRequest) {

		String pan = consentNewRunRequest.getUser().getPan();
		long overallStart = System.currentTimeMillis();

		logger.info("createNewRun started -> pan={} | workspace={} | flowId={}", pan, workspace, flowId);

		// --- API Call ---
		long apiStart = System.currentTimeMillis();
		logger.info("API call: createNewConsentRun -> pan={}", pan);

		ConsentNewRunResponse consentResponse = finarkeinClient.createNewConsentRun(flowId, workspace,
				consentNewRunRequest);

		logger.info("API call completed: createNewConsentRun -> pan={} | duration={} ms", pan,
				System.currentTimeMillis() - apiStart);

		logger.debug("ConsentNewRun API Response -> requestId={} | consentHandle={}", consentResponse.getRequestId(),
				consentResponse.getConsentHandle());

		// --- DB Save ---
		ClientConsentMappingDTO dto = mergeConsentRequestAndResponse(consentNewRunRequest, consentResponse);
		ClientConsentMappingEntity entity = dto.toEntity();

		long dbStart = System.currentTimeMillis();
		logger.info("DB save started -> pan={} | requestId={}", entity.getPan(), entity.getRequestId());

		ClientConsentMappingEntity savedEntity = clientConsentRepository.save(entity);

		logger.info("DB save completed -> pan={} | requestId={} | duration={} ms", savedEntity.getPan(),
				savedEntity.getRequestId(), System.currentTimeMillis() - dbStart);

		// --- Completion ---
		logger.info("createNewRun completed -> pan={} | totalDuration={} ms", pan,
				System.currentTimeMillis() - overallStart);

		return mapConsentEntityToResponse(savedEntity);
	}

	public RecurringNewRunResponse createNewRunFetch(String workspace, String flowId, GetRequest getRequest) {

		String pan = getRequest.getPan();
		long overallStart = System.currentTimeMillis();

		logger.info("createNewRunFetch started -> pan={} | workspace={} | flowId={}", pan, workspace, flowId);

		// --- DB Fetch ---
		long dbFetchStart = System.currentTimeMillis();
		logger.info("DB fetch latest consent object -> pan={}", pan);

		ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepository
				.getlatestClientConsentObject(pan, Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);

		if (clientConsentMappingEntity == null) {
			logger.warn("No consent mapping found -> pan={} | Aborting createNewRunFetch", pan);
			return null; // Or throw custom exception
		}

		logger.info("DB fetch completed -> pan={} | duration={} ms", pan, System.currentTimeMillis() - dbFetchStart);

		logger.debug("Fetched consentHandle={} for pan={}", clientConsentMappingEntity.getConsentHandle(), pan);

		// --- API Call ---
		RecurringNewRunRequest recurringNewRunRequest = new RecurringNewRunRequest();
		recurringNewRunRequest.setConsentHandle(clientConsentMappingEntity.getConsentHandle());

		long apiStart = System.currentTimeMillis();
		logger.info("API call: createNewRecurringRun -> pan={}", pan);

		RecurringNewRunResponse recurringResponse = finarkeinClient.createNewRecurringRun(workspace, flowId,
				recurringNewRunRequest);

		logger.info("API call completed: createNewRecurringRun -> pan={} | duration={} ms", pan,
				System.currentTimeMillis() - apiStart);

		logger.debug("RecurringNewRun API Response -> requestId={}", recurringResponse.getRequestId());

		// --- DB Save ---
		ClientConsentMappingDTO dto = mergeRecurringRequestAndResponse(clientConsentMappingEntity,
				recurringNewRunRequest, recurringResponse);
		ClientConsentMappingEntity entity = dto.toEntity();
		entity.setRunType(Constants.RECURRING);

		long dbSaveStart = System.currentTimeMillis();
		logger.info("DB save recurring run -> pan={} | requestId={}", entity.getPan(), entity.getRequestId());

		clientConsentRepository.save(entity);

		logger.info("DB save completed -> pan={} | requestId={} | duration={} ms", entity.getPan(),
				entity.getRequestId(), System.currentTimeMillis() - dbSaveStart);

		// --- Completion ---
		logger.info("createNewRunFetch completed -> pan={} | totalDuration={} ms", pan,
				System.currentTimeMillis() - overallStart);

		return recurringResponse;
	}

	public GetStatusResponse getStatus(String workspace, String flowId, String requestId) {

		long overallStart = System.currentTimeMillis();
		logger.info("getStatus started -> workspace={} | flowId={} | requestId={}", workspace, flowId, requestId);

		// --- API Call ---
		long apiStart = System.currentTimeMillis();
		logger.info("API call: getStatus -> requestId={}", requestId);

		GetStatusResponse statusResponse = finarkeinClient.getStatus(workspace, flowId, requestId);

		if (statusResponse == null || statusResponse.getState() == null) {
			logger.error("API getStatus returned null or invalid state -> requestId={}", requestId);
			return null; // Or throw custom exception
		}

		logger.info("API call completed: getStatus -> requestId={} | duration={} ms", requestId,
				System.currentTimeMillis() - apiStart);

		logger.debug("Status API Response -> state={} | consentStatus={} | dataFetchStatus={}",
				statusResponse.getState().getState(), statusResponse.getState().getConsentStatus(),
				statusResponse.getState().getDataFetchStatus());

		// --- DB Update ---
		long dbStart = System.currentTimeMillis();
		logger.info("DB updateStatus -> requestId={}", requestId);

		clientConsentRepository.updateStatus(statusResponse.getState().getState(),
				statusResponse.getState().getConsentStatus(), statusResponse.getState().getDataFetchStatus(),
				requestId);

		logger.info("DB updateStatus completed -> requestId={} | duration={} ms", requestId,
				System.currentTimeMillis() - dbStart);

		// --- Completion ---
		logger.info("getStatus completed -> requestId={} | totalDuration={} ms", requestId,
				System.currentTimeMillis() - overallStart);

		return statusResponse;
	}

	public GetResultResponse getResult(String workspace, String flowId, String requestId) {

		long overallStart = System.currentTimeMillis();
		logger.info("getResult started -> workspace={} | flowId={} | requestId={}", workspace, flowId, requestId);

		// --- API Call ---
		long apiStart = System.currentTimeMillis();
		logger.info("API call: getResult -> requestId={}", requestId);

		GetResultResponse resultResponse = finarkeinClient.getResult(workspace, flowId, requestId);

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

		ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepository.getByReferenceId(requestId);

		if (clientConsentMappingEntity == null) {
			logger.warn("No consent mapping found in DB -> requestId={}", requestId);
			return resultResponse; // API gave result, but DB mapping missing
		}

		logger.info("DB fetch completed -> requestId={} | duration={} ms", requestId,
				System.currentTimeMillis() - dbFetchStart);

		// --- Data Save Logic ---
		String pan = clientConsentMappingEntity.getPan();
		List<String> idList = new ArrayList<>();
		idList.add(pan);

		if (Constants.SUCCESS.equals(resultResponse.getState().getDataFetchStatus())) {
			long dbSaveStart = System.currentTimeMillis();
			logger.info("DB replace operation started -> pan={}", pan);

			// Delete old records
			depositHolderRepository.deleteAllById(idList);
			depositSummaryRepository.deleteAllById(idList);
			depositTransactionRepository.deleteAllById(idList);
			equityHolderRepository.deleteAllById(idList);
			equitySummaryRepository.deleteAllById(idList);
			equityTransactionRepository.deleteAllById(idList);
			mfHolderRepository.deleteAllById(idList);
			mfSummaryRepository.deleteAllById(idList);
			mfTransactionRepository.deleteAllById(idList);
			logger.debug("Deleted existing records for pan={}", pan);

			// Save new records
			depositHolderRepository
					.saveAll(mapDepositHolderResponses(resultResponse.getData().getDeposit().getHolder()));
			depositSummaryRepository
					.saveAll(mapDepositSummaryResponses(resultResponse.getData().getDeposit().getSummary()));
			depositTransactionRepository
					.saveAll(mapDepositTransactionResponses(resultResponse.getData().getDeposit().getTransactions()));
			equityHolderRepository.saveAll(mapEquityHolderResponses(resultResponse.getData().getEquity().getHolder()));
			equitySummaryRepository
					.saveAll(mapEquitySummaryResponses(resultResponse.getData().getEquity().getSummary()));
			equityTransactionRepository
					.saveAll(mapEquityTransactionResponses(resultResponse.getData().getEquity().getTransactions()));
			mfHolderRepository.saveAll(mapMFHolderResponses(resultResponse.getData().getMf().getHolder()));
			mfSummaryRepository.saveAll(mapMFSummaryResponses(resultResponse.getData().getMf().getSummary()));
			mfTransactionRepository
					.saveAll(mapMFTransactionResponses(resultResponse.getData().getMf().getTransactions()));
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

	private ClientConsentMappingDTO mergeConsentRequestAndResponse(ConsentNewRunRequest request,
			ConsentNewRunResponse response) {
		if (request == null || request.getUser() == null || response == null) {
			logger.error("mergeConsentRequestAndResponse: Null parameter(s) detected. Request={}, Response={}", request,
					response);
			return null; // or throw exception
		}

		String maskedPan = maskPan(request.getUser().getPan());

		logger.debug("Merging consent request & response | clientUserId={} | pan={} | requestId={} | consentHandle={}",
				request.getUser().getClientUserId(), maskedPan, response.getRequestId(), response.getConsentHandle());

		LocalDate dob = null;
		try {
			dob = LocalDate.parse(request.getUser().getDob());
		} catch (Exception e) {
			logger.warn("Invalid DOB format in request for clientUserId={} | value={}",
					request.getUser().getClientUserId(), request.getUser().getDob());
		}

		return new ClientConsentMappingDTO(request.getUser().getClientUserId(), request.getUser().getPan(),
				Constants.CONSENT, null, null, null, dob, response.getRequestId(), response.getConsentHandle());
	}

	private String maskPan(String pan) {
		if (pan == null || pan.length() < 4)
			return "****";
		return "****" + pan.substring(pan.length() - 4);
	}

	private ClientConsentMappingDTO mergeRecurringRequestAndResponse(
			ClientConsentMappingEntity clientConsentMappingEntity, RecurringNewRunRequest request,
			RecurringNewRunResponse response) {

		if (clientConsentMappingEntity == null || request == null || response == null) {
			logger.error("mergeRecurringRequestAndResponse: Null input(s) provided. Entity={}, Request={}, Response={}",
					clientConsentMappingEntity, request, response);
			return null; // Or throw an exception if null inputs are invalid
		}

		logger.debug(
				"Merging RecurringNewRunRequest and RecurringNewRunResponse | clientCode: {} | pan: {} | consentHandle: {} | newRequestId: {}",
				clientConsentMappingEntity.getClientCode(), clientConsentMappingEntity.getPan(),
				request.getConsentHandle(), response.getRequestId());

		return new ClientConsentMappingDTO(clientConsentMappingEntity.getClientCode(),
				clientConsentMappingEntity.getPan(), Constants.RECURRING, null, null, null,
				clientConsentMappingEntity.getDob(), response.getRequestId(), request.getConsentHandle());
	}

	private ConsentNewRunResponse mapConsentEntityToResponse(ClientConsentMappingEntity entity) {
		if (entity == null) {
			logger.error("mapConsentEntityToResponse: Provided entity is null");
			return null; // Or throw an exception if null is unexpected
		}

		logger.debug("Mapping ClientConsentMappingEntity to ConsentNewRunResponse | requestId={} | consentHandle={}",
				entity.getRequestId(), entity.getConsentHandle());

		return new ConsentNewRunResponse(entity.getRequestId(), entity.getConsentHandle(), null);
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
		if (entities == null || entities.isEmpty()) {
			logger.debug("No EquitySummaryEntity records found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} EquitySummaryEntity records to EquitySummary response objects", entities.size());

		List<EquitySummary> responseList = new ArrayList<>(entities.size());
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
		if (entities == null || entities.isEmpty()) {
			logger.debug("No EquityTransactionEntity records found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} EquityTransactionEntity records to EquityTransaction response objects",
				entities.size());

		List<EquityTransaction> responseList = new ArrayList<>(entities.size());
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
		if (entities == null || entities.isEmpty()) {
			logger.debug("No MFHolderEntity records found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFHolderEntity records to MFHolder response objects", entities.size());

		List<MFHolder> responseList = new ArrayList<>(entities.size());
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
		if (entities == null || entities.isEmpty()) {
			logger.debug("No MFSummaryEntity records found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFSummaryEntity records to MFSummary response objects", entities.size());

		List<MFSummary> responseList = new ArrayList<>(entities.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No DepositSummary responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} DepositSummary responses to DepositSummaryEntity objects", responses.size());

		List<DepositSummaryEntity> entityList = new ArrayList<>(responses.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No DepositTransaction responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} DepositTransaction responses to DepositTransactionEntity objects", responses.size());

		List<DepositTransactionEntity> entityList = new ArrayList<>(responses.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No EquityHolder responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} EquityHolder responses to EquityHolderEntity objects", responses.size());

		List<EquityHolderEntity> entityList = new ArrayList<>(responses.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No EquitySummary responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} EquitySummary responses to EquitySummaryEntity objects", responses.size());

		List<EquitySummaryEntity> entityList = new ArrayList<>(responses.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No EquityTransaction responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} EquityTransaction responses to EquityTransactionEntity objects", responses.size());

		List<EquityTransactionEntity> entityList = new ArrayList<>(responses.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No MFHolder responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFHolder responses to MFHolderEntity objects", responses.size());

		List<MFHolderEntity> entityList = new ArrayList<>(responses.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No MFSummary responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFSummary responses to MFSummaryEntity objects", responses.size());

		List<MFSummaryEntity> entityList = new ArrayList<>(responses.size());
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
		if (responses == null || responses.isEmpty()) {
			logger.debug("No MFTransaction responses found to map.");
			return new ArrayList<>();
		}

		logger.debug("Mapping {} MFTransaction responses to MFTransactionEntity objects", responses.size());

		List<MFTransactionEntity> entityList = new ArrayList<>(responses.size());
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
