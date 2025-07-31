package com.ashikha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashika.service.MyService;
import com.ashikha.data.request.ConsentNewRunRequest;
import com.ashikha.data.request.GetRequest;
import com.ashikha.data.request.GetResultRequest;
import com.ashikha.data.request.GetStatusRequest;
import com.ashikha.data.request.RecurringNewRunRequest;
import com.ashikha.data.response.ConsentNewRunResponse;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.RecurringNewRunResponse;

@RestController
@RequestMapping("/api/finarkein")
public class MyController {
	
	private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }
    
    @PostMapping("/:workspace/dp/nerv")
    public ConsentNewRunResponse createNewRun(@RequestBody ConsentNewRunRequest newRunRequest) {
        return myService.createNewRun(newRunRequest);
    }
    
    @PostMapping("/:workspace/dp/nerv/fetch")
    public RecurringNewRunResponse createNewRunFetch(@RequestBody RecurringNewRunRequest newRunRequest) {
        return myService.createNewRunFetch(newRunRequest);
    }
    
    @GetMapping("/:workspace/dp/nerv/:flowId/:requestId/status")
    public GetStatusResponse getStatus(@RequestBody GetStatusRequest getStatusRequest) {
        return myService.getStatus(getStatusRequest);
    }
    
    @GetMapping("/:workspace/dp/nerv/:flowId/:requestId/result")
    public GetResultResponse getResult(@RequestBody GetResultRequest getResultRequest) {
        return myService.getResult(getResultRequest);
    }
    
    @GetMapping("/consentStatus")
    public String checkValidConsent(@RequestBody GetRequest getRequest) {
        return myService.checkValidConsent(getRequest);
    }
    
    @GetMapping("/getDBRecords")
    public GetResultResponse getDBRecords(@RequestBody GetRequest getRequest) {
        return myService.getDBRecords(getRequest);
    }

}
