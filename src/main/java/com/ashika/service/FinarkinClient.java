package com.ashika.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashikha.data.request.NewRunRequest;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.NewRunResponse;

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

  
    public NewRunResponse initiateConsent(NewRunRequest request) {
        String url = finarkinBaseUrl + "/initiateConsent"; // Adjust endpoint name

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<NewRunRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<NewRunResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                NewRunResponse.class
        );

        return response.getBody();
    }

 
    public GetResultResponse fetchData(NewRunRequest request) {
        String url = finarkinBaseUrl + "/fetchData"; // Adjust endpoint name

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<NewRunRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<GetResultResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                GetResultResponse.class
        );

        return response.getBody();
    }

  
    public GetStatusResponse getStatus(String requestId) {
        String url = finarkinBaseUrl + "/getStatus/" + requestId;

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

 
    public GetResultResponse getResult(String requestId) {
        String url = finarkinBaseUrl + "/getResult/" + requestId;

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

