package com.ashika.service;

import com.ashika.model.dto.*;

import java.util.List;
import java.util.Optional;

import com.ashikha.data.request.GetRequest;
import com.ashikha.data.request.GetResultRequest;
import com.ashikha.data.request.GetStatusRequest;
import com.ashikha.data.request.NewRunRequest;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.NewRunResponse;

public interface MyService {

	NewRunResponse createNewRun(NewRunRequest newRunRequest);

	NewRunResponse createNewRunFetch(NewRunRequest newRunRequest);

	GetStatusResponse getStatus(GetStatusRequest getStatusRequest);

	GetResultResponse getResult(GetResultRequest getResultRequest);

	String checkValidConsent(GetRequest checkValidConsent);

	GetResultResponse getDBRecords(GetRequest getRequest);

}
