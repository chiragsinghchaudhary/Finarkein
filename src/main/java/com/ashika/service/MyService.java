package com.ashika.service;

import com.ashikha.data.request.ConsentNewRunRequest;
import com.ashikha.data.request.GetRequest;
import com.ashikha.data.response.ConsentNewRunResponse;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.RecurringNewRunResponse;

public interface MyService {

	ConsentNewRunResponse createNewRun(String workspace, String flowId, ConsentNewRunRequest newRunRequest);

	RecurringNewRunResponse createNewRunFetch(String workspace, String flowId, GetRequest getRequest);

	GetStatusResponse getStatus(String workspace, String flowId, String requestId);

	GetResultResponse getResult(String workspace, String flowId, String requestId);

	boolean checkValidConsent(GetRequest checkValidConsent);

	GetResultResponse getDBRecords(GetRequest getRequest);

}
