package com.ashika.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(FinarkeinClient.class);

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
        long startTime = System.currentTimeMillis();
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + ":" + flowId;

        logger.info("Entry: createNewConsentRun | URL: {} | workspace: {} | flowId: {} | pan: {}",
                url, workspace, flowId, maskPan(request.getUser().getPan()));

        try {
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

	public RecurringNewRunResponse createNewRecurringRun(String workspace, String flowId, RecurringNewRunRequest request) {
        long startTime = System.currentTimeMillis();
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + finarkeinFetchUrl + flowId;

        logger.info("Entry: createNewRecurringRun | URL: {} | workspace: {} | flowId: {} | consentHandle: {}",
                url, workspace, flowId, request.getConsentHandle());

        try {
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

    public GetStatusResponse getStatus(String workspace, String flowId, String requestId) {
        long startTime = System.currentTimeMillis();
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + ":" + flowId + "/:" + requestId + finarkeinStatusUrl;

        logger.info("Entry: getStatus | URL: {} | workspace: {} | flowId: {} | requestId: {}",
                url, workspace, flowId, requestId);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + authToken);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

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

    public GetResultResponse getResult(String workspace, String flowId, String requestId) {
        long startTime = System.currentTimeMillis();
        String url = finarkeinBaseUrl + workspace + finarkeinCommmonUrl + ":" + flowId + "/:" + requestId + finarkeinResultUrl;

        logger.info("Entry: getResult | URL: {} | workspace: {} | flowId: {} | requestId: {}",
                url, workspace, flowId, requestId);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + authToken);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

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

    /** Mask PAN for security (show last 4 digits only) */
    private String maskPan(String pan) {
        if (pan == null || pan.length() < 4) return "****";
        return "****" + pan.substring(pan.length() - 4);
    }
}
