package com.ashika.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashika.data.request.ConsentNewRunRequest;
import com.ashika.data.request.GetRequest;
import com.ashika.data.request.RecurringNewRunRequest;
import com.ashika.data.response.BaseResponse;
import com.ashika.data.response.ConsentNewRunResponse;
import com.ashika.data.response.GetResultResponse;
import com.ashika.data.response.GetStatusResponse;
import com.ashika.data.response.RecurringNewRunResponse;
import com.ashika.service.MyService;

@RestController
@RequestMapping("/api/finarkein")
public class MyController {

	@Autowired
    private MyService myService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyController() {
    	logger.debug("MyController initialized");
	}
    
    @GetMapping("/hello")
    public String helloWorld() {
    	logger.info("Entry: /helloWorld");
        return "Hello World!";
    }
    
    @PostMapping("/createNewConsentRun")
    public ConsentNewRunResponse createNewRun(@RequestBody ConsentNewRunRequest consentNewRunRequest) {
    	
    	long startTimeInMilliseconds = System.currentTimeMillis();
    	
    	logger.info("Entry: /createNewRun " + " pan : " + consentNewRunRequest.getIdentifiers().getPan());
    	
    	ConsentNewRunResponse consentNewRunResponse = myService.createNewRun(consentNewRunRequest);
    	
    	long timeTakenToProcessRequest = System.currentTimeMillis() - startTimeInMilliseconds;
    	
    	logger.info("Exit: /createNewRun " + " pan : " + consentNewRunRequest.getIdentifiers().getPan()
    			+ " ProcessingTime : " + timeTakenToProcessRequest);
    	
    	return consentNewRunResponse;
    }

    @PostMapping("/createNewFetchRun")
    public RecurringNewRunResponse createNewRunFetch(@RequestBody GetRequest getRequest) {
    	
    	long startTimeInMilliseconds = System.currentTimeMillis();
    	
    	logger.info("Entry: /createNewRunFetch " + " pan : " + getRequest.getPan());
    	
    	RecurringNewRunResponse recurringNewRunResponse = myService.createNewRunFetch(getRequest);
    	
    	long timeTakenToProcessRequest = System.currentTimeMillis() - startTimeInMilliseconds;
    	
		
		  logger.info("Exit: /createNewRunFetch " + " pan : " + getRequest.getPan() +
		  " ProcessingTime : " + timeTakenToProcessRequest);
		 
    	
        return recurringNewRunResponse;
    }

    @GetMapping("/getStatus/{requestId}")
    public GetStatusResponse getStatus(@PathVariable("requestId") String requestId) {
    	
    	long startTimeInMilliseconds = System.currentTimeMillis();
    	
    	logger.info("Entry: /getStatus " + " requestId : " + requestId );
    	
    	GetStatusResponse getStatusResponse = myService.getStatus(requestId);
    	
    	long timeTakenToProcessRequest = System.currentTimeMillis() - startTimeInMilliseconds;
    	
    	logger.info("Exit: /getStatus " + " requestId : " + requestId
    			+ " ProcessingTime : " + timeTakenToProcessRequest);
    	
        return getStatusResponse;
    }

    @GetMapping("/getResult/{requestId}")
    public GetResultResponse getResult(@PathVariable("requestId") String requestId) {
    	
    	long startTimeInMilliseconds = System.currentTimeMillis();
    	
    	logger.info("Entry: /getResult " + " requestId : " + requestId );
    	
    	
    	GetResultResponse getResultResponse = myService.getResult(requestId);
    	
    	long timeTakenToProcessRequest = System.currentTimeMillis() - startTimeInMilliseconds;
    	
    	logger.info("Exit: /getResult " + " requestId : " + requestId
    			+ " ProcessingTime : " + timeTakenToProcessRequest);
    	
        return getResultResponse;
    }

    @GetMapping("/checkValidConsent")
    public BaseResponse checkValidConsent(@RequestBody GetRequest getRequest) {
    	
    	long startTimeInMilliseconds = System.currentTimeMillis();
    	
    	logger.info("Entry: /checkValidConsent " + " pan : " + getRequest.getPan());
    	
    	BaseResponse baseResponse = myService.checkValidConsent(getRequest);
    	
    	long timeTakenToProcessRequest = System.currentTimeMillis() - startTimeInMilliseconds;
    	
    	logger.info("Exit: /getResult " + " pan : " + getRequest.getPan()
    			+ " ProcessingTime : " + timeTakenToProcessRequest);
    	
        return baseResponse;
    }

    @GetMapping("/getDBRecords")
    public GetResultResponse getDBRecords(@RequestBody GetRequest getRequest) {
    	
    	long startTimeInMilliseconds = System.currentTimeMillis();
    	
    	logger.info("Entry: /getDBRecords " + " pan : " + getRequest.getPan());
    	
    	GetResultResponse getResultResponse = myService.getDBRecords(getRequest);
    	
    	long timeTakenToProcessRequest = System.currentTimeMillis() - startTimeInMilliseconds;
    	
    	logger.info("Exit: /getDBRecords " + " pan : " + getRequest.getPan()
    			+ " ProcessingTime : " + timeTakenToProcessRequest);
    	
        return getResultResponse;
    }
}


