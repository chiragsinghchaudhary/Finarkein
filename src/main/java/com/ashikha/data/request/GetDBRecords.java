package com.ashikha.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetDBRecords {

    @JsonProperty("pan")
    private String pan;

    
    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
