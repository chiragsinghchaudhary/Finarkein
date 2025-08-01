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
import com.ashikha.data.response.DepositResponse;
import com.ashikha.data.response.EquityResponse;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.MFResponse;
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
}

