package com.algorithmswiki.apps.backend.backend.Object;

public class LoginObject {
    private String access_token;
    private int status_code;

    public LoginObject() { }

    public LoginObject(String access_token, int status_code) {
        this.access_token = access_token;
        this.status_code = status_code;
    }

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String access_token) {
        this.access_token = access_token;
    }

    public int getStatusCode() {
        return status_code;
    }

    public void setStatusCode(int status_code) {
        this.status_code = status_code;
    }
}
