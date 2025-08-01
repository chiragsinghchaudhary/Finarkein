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
import com.ashika.repository.ClientConsentMappingHistRepository;
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
import com.ashikha.data.response.State;

@Service
public abstract class MyServceImpl implements MyService {

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

	private FinarkinClient finarkinClient = new FinarkinClient();

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
		ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepository.getlatestClientConsentObject(
				getRequest.getPan(), Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);

		if (clientConsentMappingEntity.getState().equals(Constants.SUCCESS)
				&& clientConsentMappingEntity.getConsentStatus().equals(Constants.ACTIVE)
				&& clientConsentMappingEntity.getConsentStatus().equals(Constants.SUCCESS)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public GetResultResponse getDBRecords(GetRequest getRequest) {
		List<String> idList = new ArrayList<>();
		idList.add(getRequest.getPan());

		List<DepositHolderEntity> listDepositHolderEntities = depositHolderRepository.findAllById(idList);

		List<DepositSummaryEntity> listDepositSummaryEntities = depositSummaryRepository.findAllById(idList);

		List<DepositTransactionEntity> listDepositTransactionEntities = depositTransactionRepository
				.findAllById(idList);

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

		return getResultResponse;
	}

	@Override
	public ConsentNewRunResponse createNewRun(String workspace, String flowId,
			ConsentNewRunRequest consentNewRunRequest) {
		ConsentNewRunResponse consentResponse = finarkinClient.createNewConsentRun(flowId, workspace,
				consentNewRunRequest);
		ClientConsentMappingDTO dto = mergeConsentRequestAndResponse(consentNewRunRequest, consentResponse);
		ClientConsentMappingEntity entity = dto.toEntity();
		ClientConsentMappingEntity savedEntity = clientConsentRepository.save(entity);
		return mapConsentEntityToResponse(savedEntity);
	}

	@Override
	public RecurringNewRunResponse createNewRunFetch(String workspace, String flowId, GetRequest getRequest) {

		ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepository.getlatestClientConsentObject(
				getRequest.getPan(), Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);

		RecurringNewRunRequest recurringNewRunRequest = new RecurringNewRunRequest();
		recurringNewRunRequest.setConsentHandle(clientConsentMappingEntity.getConsentHandle());

		RecurringNewRunResponse recurringResponse = finarkinClient.createNewRecurringRun(workspace, flowId,
				recurringNewRunRequest);
		ClientConsentMappingDTO dto = mergeRecurringRequestAndResponse(clientConsentMappingEntity,
				recurringNewRunRequest, recurringResponse);

		ClientConsentMappingEntity entity = dto.toEntity();
		entity.setRunType(Constants.RECURRING);
		clientConsentRepository.save(entity);
		return recurringResponse;
	}

	@Override
	public GetStatusResponse getStatus(String workspace, String flowId, String requestId) {
		GetStatusResponse statusResponse = finarkinClient.getStatus(workspace, flowId, requestId);
		clientConsentRepository.updateStatus(statusResponse.getState().getState(),
				statusResponse.getState().getConsentStatus(), statusResponse.getState().getDataFetchStatus(),
				requestId);

		return statusResponse;
	}

	@Override
	public GetResultResponse getResult(String workspace, String flowId, String requestId) {
		GetResultResponse resultResponse = finarkinClient.getResult(workspace, flowId, requestId);

		List<String> idList = new ArrayList<>();
		idList.add(requestId);

		if (resultResponse.getState().getDataFetchStatus().equals(Constants.SUCCESS)) {
			depositHolderRepository.deleteAllById(idList);
			depositSummaryRepository.deleteAllById(idList);
			depositTransactionRepository.deleteAllById(idList);
			equityHolderRepository.deleteAllById(idList);
			equitySummaryRepository.deleteAllById(idList);
			equityTransactionRepository.deleteAllById(idList);
			mfHolderRepository.deleteAllById(idList);
			mfSummaryRepository.deleteAllById(idList);
			mfTransactionRepository.deleteAllById(idList);
			
			
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

		return resultResponse;
	}

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

	private GetResultResponse mapEntityToGetResultResponse(ClientConsentMappingEntity entity) {
		GetResultResponse response = new GetResultResponse();
		response.setRequestId(entity.getRequestId());
		State state = new State();
		state.setState(entity.getState());
		state.setConsentStatus(entity.getConsentStatus());
		state.setDataFetchStatus(entity.getDataFetchStatus());
		response.setState(state);
		return response;
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

	private List<EquitySummary> mapEquitySummaryEntities(List<EquitySummaryEntity> entities) {
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
		return responseList;
	}

	private List<EquityTransaction> mapEquityTransactionEntities(List<EquityTransactionEntity> entities) {
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
		return responseList;
	}

	private List<MFHolder> mapMFHolderEntities(List<MFHolderEntity> entities) {
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
		return responseList;
	}

	private List<MFSummary> mapMFSummaryEntities(List<MFSummaryEntity> entities) {
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
		return responseList;
	}

	private List<MFTransaction> mapMFTransactionEntities(List<MFTransactionEntity> entities) {
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
		return responseList;
	}

	private List<DepositHolderEntity> mapDepositHolderResponses(List<DepositHolder> responses) {
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
    return entityList;
}
private List<DepositSummaryEntity> mapDepositSummaryResponses(List<DepositSummary> responses) {
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
    return entityList;
}
private List<DepositTransactionEntity> mapDepositTransactionResponses(List<DepositTransaction> responses) {
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
    return entityList;
}
private List<EquityHolderEntity> mapEquityHolderResponses(List<EquityHolder> responses) {
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
    return entityList;
}
private List<EquitySummaryEntity> mapEquitySummaryResponses(List<EquitySummary> responses) {
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
    return entityList;
}
private List<EquityTransactionEntity> mapEquityTransactionResponses(List<EquityTransaction> responses) {
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
    return entityList;
}
private List<MFHolderEntity> mapMFHolderResponses(List<MFHolder> responses) {
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
    return entityList;
}
private List<MFSummaryEntity> mapMFSummaryResponses(List<MFSummary> responses) {
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
    return entityList;
}
private List<MFTransactionEntity> mapMFTransactionResponses(List<MFTransaction> responses) {
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
    return entityList;
}

}
