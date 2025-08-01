package com.ashika.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashikha.data.request.ConsentNewRunRequest;
import com.ashikha.data.request.RecurringNewRunRequest;
import com.ashikha.data.response.ConsentNewRunResponse;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.RecurringNewRunResponse;

@Service
public class FinarkeinClient {

    private final RestTemplate restTemplate;

    @Value("${finarkein.api.base-url}")
    private String finarkeinBaseUrl;
    
    @Value("${finarkein.api.common-url}")
    private String finarkeinCommmonUrl;
    
    @Value("${finarkein.api.fetch.run-url}")
    private String finarkeinFetchUrl;
    
    @Value("${finarkein.api.status-url}")
    private String finarkeinStatusUrl;
    
    @Value("${finarkein.api.result-url}")
    private String finarkeinResultUrl;

    @Value("${finarkein.api.auth-token}")
    private String authToken;

    public FinarkeinClient() {
        this.restTemplate = new RestTemplate();
    }

    public ConsentNewRunResponse createNewConsentRun(String workspace, String flowId, ConsentNewRunRequest request) {
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + ":" + flowId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<ConsentNewRunRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ConsentNewRunResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                ConsentNewRunResponse.class
        );

        return response.getBody();
    }

    public RecurringNewRunResponse createNewRecurringRun(String workspace, String flowId, RecurringNewRunRequest request) {
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + finarkeinFetchUrl + flowId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<RecurringNewRunRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<RecurringNewRunResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                RecurringNewRunResponse.class
        );

        return response.getBody();
    }

    public GetStatusResponse getStatus(String workspace, String flowId, String requestId) {
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + ":" + flowId + "/:" + requestId + finarkeinStatusUrl;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<GetStatusResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                GetStatusResponse.class
        );

        return response.getBody();
    }

    public GetResultResponse getResult(String workspace, String flowId, String requestId) {
    	String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + ":" + flowId + "/:" + requestId + finarkeinResultUrl;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<GetResultResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                GetResultResponse.class
        );

        return response.getBody();
    }
}
