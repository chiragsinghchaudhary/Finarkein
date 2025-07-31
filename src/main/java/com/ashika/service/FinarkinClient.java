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
public class FinarkinClient {

    private final RestTemplate restTemplate;

    @Value("${finarkin.api.base-url}")
    private String finarkinBaseUrl;

    @Value("${finarkin.api.auth-token}")
    private String authToken;

    public FinarkinClient() {
        this.restTemplate = new RestTemplate();
    }

    public ConsentNewRunResponse createNewConsentRun(String workspace, String flowId, ConsentNewRunRequest request) {
        String url = finarkinBaseUrl + "/v2/workspace/" + workspace + "/flow/" + flowId + "/consent/initiate";

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
        String url = finarkinBaseUrl + "/v2/workspace/" + workspace + "/flow/" + flowId + "/recurring/initiate";

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

    public GetStatusResponse getStatus(String workspace, String requestId) {
        String url = finarkinBaseUrl + "/v2/workspace/" + workspace + "/runs/" + requestId + "/status";

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

    public GetResultResponse getResult(String workspace, String requestId) {
        String url = finarkinBaseUrl + "/v2/workspace/" + workspace + "/runs/" + requestId + "/result";

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
