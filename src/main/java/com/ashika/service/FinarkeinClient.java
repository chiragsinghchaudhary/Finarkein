package com.ashika.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ashika.Constants;
import com.ashika.data.request.ConsentNewRunRequest;
import com.ashika.data.request.RecurringNewRunRequest;
import com.ashika.data.response.ConsentNewRunResponse;
import com.ashika.data.response.GetResultResponse;
import com.ashika.data.response.GetStatusResponse;
import com.ashika.data.response.RecurringNewRunResponse;

@Service
public class FinarkeinClient {

    private static final Logger logger = LoggerFactory.getLogger(FinarkeinClient.class);

    @Value("${finarkein.api.base-url}")
    private String finarkeinBaseUrl;

    @Value("${finarkein.api.workspace}")
    private String workspace;

    @Value("${finarkein.api.flowId}")
    private String flowId;

    @Value("${finarkein.api.common-url}")
    private String finarkeinCommmonUrl;

    @Value("${finarkein.api.fetch.run-url}")
    private String finarkeinFetchUrl;

    @Value("${finarkein.api.status-url}")
    private String finarkeinStatusUrl;

    @Value("${finarkein.api.result-url}")
    private String finarkeinResultUrl;

    @Value("${finarkein.api.auth-token-url}")
    private String authTokenUrl;

    @Value("${finarkein.api.client-id}")
    private String clientId;

    @Value("${finarkein.api.client-secret}")
    private String clientSecret;
    
    public FinarkeinClient() {
		logger.debug("FinarkeinClient initialized");
	}

    public ConsentNewRunResponse createNewConsentRun(ConsentNewRunRequest request) {
        long startTime = System.currentTimeMillis();
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + flowId;

        logger.info("Entry: createNewConsentRun | URL: {} | workspace: {} | flowId: {} | pan: {}",
                url, workspace, flowId, maskPan(request.getIdentifiers().getPan()));

        try {
            String accessToken = getAuthToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + accessToken);
            headers.set("Content-Type", "application/json");

            HttpEntity<ConsentNewRunRequest> entity = new HttpEntity<>(request, headers);
            
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<ConsentNewRunResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    ConsentNewRunResponse.class
            );

            long timeTaken = System.currentTimeMillis() - startTime;
            logger.info("Exit: createNewConsentRun | workspace: {} | flowId: {} | ProcessingTime: {} ms",
                    workspace, flowId, timeTaken);

            return response.getBody();

        } catch (Exception ex) {
            logger.error("Error in createNewConsentRun | workspace: {} | flowId: {} | Error: {}",
                    workspace, flowId, ex.getMessage(), ex);
            throw ex;
        }
    }

    public RecurringNewRunResponse createNewRecurringRun(RecurringNewRunRequest request) {
        long startTime = System.currentTimeMillis();
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + finarkeinFetchUrl + flowId;

        logger.info("Entry: createNewRecurringRun | URL: {} | workspace: {} | flowId: {} | consentHandle: {}",
                url, workspace, flowId, request.getConsentHandle());

        try {
            String accessToken = getAuthToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + accessToken);
            headers.set("Content-Type", "application/json");

            HttpEntity<RecurringNewRunRequest> entity = new HttpEntity<>(request, headers);
            
            

            RestTemplate restTemplate = new RestTemplate();
            
			ResponseEntity<RecurringNewRunResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    RecurringNewRunResponse.class
            );

            long timeTaken = System.currentTimeMillis() - startTime;
            logger.info("Exit: createNewRecurringRun | workspace: {} | flowId: {} | ProcessingTime: {} ms",
                    workspace, flowId, timeTaken);

            return response.getBody();

        } catch (Exception ex) {
            logger.error("Error in createNewRecurringRun | workspace: {} | flowId: {} | Error: {}",
                    workspace, flowId, ex.getMessage(), ex);
            throw ex;
        }
    }

    public GetStatusResponse getStatus(String requestId) {
        long startTime = System.currentTimeMillis();
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + flowId + "/" + requestId + finarkeinStatusUrl;

        logger.info("Entry: getStatus | URL: {} | workspace: {} | flowId: {} | requestId: {}",
                url, workspace, flowId, requestId);

        try {
            String accessToken = getAuthToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + accessToken);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            
            ResponseEntity<GetStatusResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    GetStatusResponse.class
            );

            long timeTaken = System.currentTimeMillis() - startTime;
            logger.info("Exit: getStatus | workspace: {} | flowId: {} | requestId: {} | ProcessingTime: {} ms",
                    workspace, flowId, requestId, timeTaken);

            return response.getBody();

        } catch (Exception ex) {
            logger.error("Error in getStatus | workspace: {} | flowId: {} | requestId: {} | Error: {}",
                    workspace, flowId, requestId, ex.getMessage(), ex);
            throw ex;
        }
    }

    public GetResultResponse getResult(String requestId) {
        long startTime = System.currentTimeMillis();
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + flowId + "/" + requestId + finarkeinResultUrl;

        logger.info("Entry: getResult | URL: {} | workspace: {} | flowId: {} | requestId: {}",
                url, workspace, flowId, requestId);

        try {
            String accessToken = getAuthToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + accessToken);

            HttpEntity<Void> entity = new HttpEntity<>(headers);
            
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<GetResultResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    GetResultResponse.class
            );

            long timeTaken = System.currentTimeMillis() - startTime;
            logger.info("Exit: getResult | workspace: {} | flowId: {} | requestId: {} | ProcessingTime: {} ms",
                    workspace, flowId, requestId, timeTaken);

            return response.getBody();

        } catch (Exception ex) {
            logger.error("Error in getResult | workspace: {} | flowId: {} | requestId: {} | Error: {}",
                    workspace, flowId, requestId, ex.getMessage(), ex);
            throw ex;
        }
    }

private String getAuthToken() {
    long startTime = System.currentTimeMillis();
    logger.info("Entry: getAuthToken | URL: {}", authTokenUrl);

    try {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(clientId, clientSecret, StandardCharsets.UTF_8);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials"); // can also be moved to properties if needed

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(authTokenUrl, request, Map.class);

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Exit: getAuthToken | Time taken: {} ms", timeTaken);

        if (response.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("access_token")) {
                return (String) responseBody.get("access_token");
            }
            throw new RuntimeException("Access token not found in response.");
        } else {
            throw new RuntimeException("Failed to fetch token. Status: " + response.getStatusCode());
        }
    } catch (Exception ex) {
        logger.error("Error in getAuthToken | Error: {}", ex.getMessage(), ex);
        throw new RuntimeException("Exception while fetching auth token", ex);
    }
}

    private String maskPan(String pan) {
        if (pan == null || pan.length() < 4) return "****";
        return "****" + pan.substring(pan.length() - 4);
    }
}
