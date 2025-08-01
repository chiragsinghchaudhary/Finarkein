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
    private final DepositSummaryRepository depositSummaryRepo;
    private final DepositTransactionRepository depositTransactionRepo;

    private final EquityHolderRepository equityHolderRepository;
    private final EquitySummaryRepository equitySummaryRepo;
    private final EquityTransactionRepository equityTransactionRepo;

    private final MFHolderRepository mfHolderRepository;
    private final MFSummaryRepository mfSummaryRepo;
    private final MFTransactionRepository mfTransactionRepo;

    private final ClientConsentMappingRepository clientConsentRepo;
    private final ClientConsentMappingHistRepository clientConsentHistRepo;

    private FinarkinClient finarkinClient = new FinarkinClient();

    public MyServceImpl(
            DepositHolderRepository depositHolderRepository,
            DepositSummaryRepository depositSummaryRepo,
            DepositTransactionRepository depositTransactionRepo,
            EquityHolderRepository equityHolderRepository,
            EquitySummaryRepository equitySummaryRepo,
            EquityTransactionRepository equityTransactionRepo,
            MFHolderRepository mfHolderRepository,
            MFSummaryRepository mfSummaryRepo,
            MFTransactionRepository mfTransactionRepo,
            ClientConsentMappingRepository clientConsentRepo,
            ClientConsentMappingHistRepository clientConsentHistRepo) {
        this.depositHolderRepository = depositHolderRepository;
        this.depositSummaryRepo = depositSummaryRepo;
        this.depositTransactionRepo = depositTransactionRepo;
        this.equityHolderRepository = equityHolderRepository;
        this.equitySummaryRepo = equitySummaryRepo;
        this.equityTransactionRepo = equityTransactionRepo;
        this.mfHolderRepository = mfHolderRepository;
        this.mfSummaryRepo = mfSummaryRepo;
        this.mfTransactionRepo = mfTransactionRepo;
        this.clientConsentRepo = clientConsentRepo;
        this.clientConsentHistRepo = clientConsentHistRepo;
    }

    @Override
    public ConsentNewRunResponse createNewRun(String workspace, String flowId, ConsentNewRunRequest consentNewRunRequest) {
        ConsentNewRunResponse consentResponse = finarkinClient.createNewConsentRun(flowId, workspace, consentNewRunRequest);
        ClientConsentMappingDTO dto = mergeConsentRequestAndResponse(consentNewRunRequest, consentResponse);
        ClientConsentMappingEntity entity = dto.toEntity();
        ClientConsentMappingEntity savedEntity = clientConsentRepo.save(entity);
        return mapConsentEntityToResponse(savedEntity);
    }

    @Override
    public RecurringNewRunResponse createNewRunFetch(String workspace, String flowId, GetRequest getRequest) {
    	
    	ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepo.getlatestClientConsentObject(getRequest.getPan(), Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);
    	
    	RecurringNewRunRequest recurringNewRunRequest = new RecurringNewRunRequest();
    	recurringNewRunRequest.setConsentHandle(clientConsentMappingEntity.getConsentHandle());
    	
        RecurringNewRunResponse recurringResponse = finarkinClient.createNewRecurringRun(workspace, flowId, recurringNewRunRequest);
        ClientConsentMappingDTO dto = mergeRecurringRequestAndResponse(clientConsentMappingEntity, recurringNewRunRequest, recurringResponse);
        
        
        ClientConsentMappingEntity entity = dto.toEntity();
        entity.setRunType(Constants.RECURRING);
        clientConsentRepo.save(entity);
        return recurringResponse;
    }


    @Override
    public GetStatusResponse getStatus(String workspace, String flowId, String requestId) {
        GetStatusResponse statusResponse = finarkinClient.getStatus(workspace, flowId, requestId);
        clientConsentRepo.updateStatus(
                statusResponse.getState().getState(),
                statusResponse.getState().getConsentStatus(),
                statusResponse.getState().getDataFetchStatus(),
                requestId
        );

        return statusResponse;
    }

    @Override
    public GetResultResponse getResult(String workspace, String flowId, String requestId) {
        GetResultResponse resultResponse = finarkinClient.getResult(workspace, flowId, requestId);
        
        if(resultResponse.isSuccess()) {
        	
        }
        
        return resultResponse;
    }

    private ClientConsentMappingDTO mergeConsentRequestAndResponse(ConsentNewRunRequest request, ConsentNewRunResponse response) {
        return new ClientConsentMappingDTO(
                request.getUser().getClientUserId(),
                request.getUser().getPan(),
                Constants.CONSENT,
                null,
                null,
                null,
                LocalDate.parse(request.getUser().getDob()),
                response.getRequestId(),
                response.getConsentHandle()
        );
    }

    private ClientConsentMappingDTO mergeRecurringRequestAndResponse(ClientConsentMappingEntity clientConsentMappingEntity,
    		RecurringNewRunRequest request, RecurringNewRunResponse response) {
        return new ClientConsentMappingDTO(
        		clientConsentMappingEntity.getClientCode(),
        		clientConsentMappingEntity.getPan(),
        		Constants.RECURRING,
        		null,
        		null,
        		null,
        		clientConsentMappingEntity.getDob(),
                response.getRequestId(),
                request.getConsentHandle()
        );
    }

    private ConsentNewRunResponse mapConsentEntityToResponse(ClientConsentMappingEntity entity) {
        return new ConsentNewRunResponse(
                entity.getRequestId(),
                entity.getConsentHandle(),
                null 
        );
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

    @Override
    public boolean checkValidConsent(GetRequest getRequest) {
    	ClientConsentMappingEntity clientConsentMappingEntity = clientConsentRepo.getlatestClientConsentObject(getRequest.getPan(), Constants.CONSENT, Constants.SUCCESS, Constants.ACTIVE);
    	
    	if(clientConsentMappingEntity.getState().equals(Constants.SUCCESS) &&
    	clientConsentMappingEntity.getConsentStatus().equals(Constants.ACTIVE) &&
    	clientConsentMappingEntity.getConsentStatus().equals(Constants.SUCCESS)){
    		return true;
    	}else {
    		return false;
    	}
    }

    @Override
    public GetResultResponse getDBRecords(GetRequest getRequest) {
    	List<String> idList = new ArrayList<>();
    	idList.add(getRequest.getPan());
    	
    	List<DepositHolderEntity> listDepositHolderEntities = depositHolderRepository.findAllById(idList);
    	
    	List<DepositSummaryEntity> listDepositSummaryEntities = depositSummaryRepo.findAllById(idList);
    	
    	List<DepositTransactionEntity> listDepositTransactionEntities = depositTransactionRepo.findAllById(idList);
    	
    	List<EquityHolderEntity> listEquityHolderEntities = equityHolderRepository.findAllById(idList);
    	
    	List<EquitySummaryEntity> listEquitySummaryEntities = equitySummaryRepo.findAllById(idList);
    	
    	List<EquityTransactionEntity> listEquityTransactionEntities = equityTransactionRepo.findAllById(idList);
    	
    	List<MFHolderEntity> listHolderEntities = mfHolderRepository.findAllById(idList);
    	
    	List<MFSummaryEntity> listMfSummaryEntities = mfSummaryRepo.findAllById(idList);
    	
    	List<MFTransactionEntity> listMfTransactionEntities = mfTransactionRepo.findAllById(idList);
    	
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
        response.setStartDate(entity.getStartDate());
        response.setEndDate(entity.getEndDate());
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
}

