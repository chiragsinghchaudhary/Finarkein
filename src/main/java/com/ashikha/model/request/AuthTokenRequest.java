//Request body for authentication token
package com.ashikha.model.request;

public class AuthTokenRequest {

    private String grantType;

    public AuthTokenRequest() {
        this.grantType = "client_credentials";
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
