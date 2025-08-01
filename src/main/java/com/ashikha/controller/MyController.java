package com.ashikha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashika.service.MyService;
import com.ashikha.data.request.ConsentNewRunRequest;
import com.ashikha.data.request.GetRequest;
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

    @PostMapping("/{workspace}/dp/nerv/{flowId}")
    public ConsentNewRunResponse createNewRun(@PathVariable("workspace") String workspace,
                                              @PathVariable("flowId") String flowId,
                                              @RequestBody ConsentNewRunRequest consentNewRunRequest) {
        return myService.createNewRun(workspace, flowId, consentNewRunRequest);
    }

    @PostMapping("/{workspace}/dp/nerv/fetch/{flowId}")
    public RecurringNewRunResponse createNewRunFetch(@PathVariable("workspace") String workspace,
                                                     @PathVariable("flowId") String flowId,
                                                     @RequestBody GetRequest getRequest) {
        return myService.createNewRunFetch(workspace, flowId, getRequest);
    }

    @GetMapping("/{workspace}/dp/nerv/{flowId}/{requestId}/status")
    public GetStatusResponse getStatus(@PathVariable("workspace") String workspace,
                                       @PathVariable("flowId") String flowId,
                                       @PathVariable("requestId") String requestId) {
        return myService.getStatus(workspace, flowId, requestId);
    }

    @GetMapping("/{workspace}/dp/nerv/{flowId}/{requestId}/result")
    public GetResultResponse getResult(@PathVariable("workspace") String workspace,
                                       @PathVariable("flowId") String flowId,
                                       @PathVariable("requestId") String requestId) {
        return myService.getResult(workspace, flowId, requestId);
    }

    @GetMapping("/checkValidConsent")
    public boolean checkValidConsent(@RequestBody GetRequest getRequest) {
        return myService.checkValidConsent(getRequest);
    }

    @GetMapping("/getDBRecords")
    public GetResultResponse getDBRecords(@RequestBody GetRequest getRequest) {
        return myService.getDBRecords(getRequest);
    }
}


