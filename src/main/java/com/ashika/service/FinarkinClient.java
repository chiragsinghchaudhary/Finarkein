package com.ashika.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashikha.data.request.NewRunRequest;
import com.ashikha.data.response.FinarkinResponse;
import com.ashikha.data.response.FinarkinResultResponse;
import com.ashikha.data.response.FinarkinStatusResponse;

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

  
    public FinarkinResponse initiateConsent(NewRunRequest request) {
        String url = finarkinBaseUrl + "/initiateConsent"; // Adjust endpoint name

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<NewRunRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<FinarkinResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                FinarkinResponse.class
        );

        return response.getBody();
    }

 
    public FinarkinResponse fetchData(NewRunRequest request) {
        String url = finarkinBaseUrl + "/fetchData"; // Adjust endpoint name

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        headers.set("Content-Type", "application/json");

        HttpEntity<NewRunRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<FinarkinResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                FinarkinResponse.class
        );

        return response.getBody();
    }

  
    public FinarkinStatusResponse getStatus(String requestId) {
        String url = finarkinBaseUrl + "/getStatus/" + requestId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<FinarkinStatusResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                FinarkinStatusResponse.class
        );

        return response.getBody();
    }

 
    public FinarkinResultResponse getResult(String requestId) {
        String url = finarkinBaseUrl + "/getResult/" + requestId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<FinarkinResultResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                FinarkinResultResponse.class
        );

        return response.getBody();
    }
}

