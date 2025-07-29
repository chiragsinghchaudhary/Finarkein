package com.ashikha.service;

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

}
