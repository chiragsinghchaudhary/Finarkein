package com.ashikha.service;

import org.springframework.stereotype.Service;

import com.ashikha.data.request.GetResultRequest;
import com.ashikha.data.request.GetStatusRequest;
import com.ashikha.data.request.NewRunRequest;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.NewRunResponse;

@Service
public class MyServceImpl implements MyService {

	@Override
	public NewRunResponse createNewRun(NewRunRequest newRunRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewRunResponse createNewRunFetch(NewRunRequest newRunRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetStatusResponse getStatus(GetStatusRequest getStatusRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetResultResponse getResult(GetResultRequest getResultRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
