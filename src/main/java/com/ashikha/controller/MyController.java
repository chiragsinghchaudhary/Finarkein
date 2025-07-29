package com.ashikha.controller;

import org.springframework.web.bind.annotation.*;

import com.ashika.service.MyService;
import com.ashikha.data.request.GetResultRequest;
import com.ashikha.data.request.GetStatusRequest;
import com.ashikha.data.request.NewRunRequest;
import com.ashikha.data.response.GetResultResponse;
import com.ashikha.data.response.GetStatusResponse;
import com.ashikha.data.response.NewRunResponse;

@RestController
@RequestMapping("/api/finarkein")
public class MyController {
	
	private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }
    
    @PostMapping("/:workspace/dp/nerv")
    public NewRunResponse createNewRun(@RequestBody NewRunRequest newRunRequest) {
        return myService.createNewRun(newRunRequest);
    }
    
    @PostMapping("/:workspace/dp/nerv/fetch")
    public NewRunResponse createNewRunFetch(@RequestBody NewRunRequest newRunRequest) {
        return myService.createNewRunFetch(newRunRequest);
    }
    
    @GetMapping("/:workspace/dp/nerv/:flowId/:requestId/status")
    public GetStatusResponse getStatus(@RequestBody GetStatusRequest getStatusRequest) {
        return myService.getStatus(getStatusRequest);
    }
    
    @GetMapping("/:workspace/dp/nerv/:flowId/:requestId/status")
    public GetResultResponse getResult(@RequestBody GetResultRequest getResultRequest) {
        return myService.getResult(getResultRequest);
    }

}
