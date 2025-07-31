package com.ashika.service;

import com.ashikha.data.request.ConsentNewRunRequest;
import com.ashikha.data.request.GetRequest;
import com.ashikha.data.request.GetResultRequest;
import com.ashikha.data.request.GetStatusRequest;
import com.ashikha.data.request.RecurringNewRunRequest;
import com.ashikha.data.response.ConsentNewRunResponse;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.RecurringNewRunResponse;

public interface MyService {

	ConsentNewRunResponse createNewRun(ConsentNewRunRequest newRunRequest);

	RecurringNewRunResponse createNewRunFetch(RecurringNewRunRequest newRunRequest);

	GetStatusResponse getStatus(GetStatusRequest getStatusRequest);

	GetResultResponse getResult(GetResultRequest getResultRequest);

	String checkValidConsent(GetRequest checkValidConsent);

	GetResultResponse getDBRecords(GetRequest getRequest);

}
