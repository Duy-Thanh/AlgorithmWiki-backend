package com.algorithmswiki.apps.backend.backend.Object;

public class DefaultObject {
    private String message;
    private String value;
    private int status_code;

    public DefaultObject() { }

    // Constructor
    public DefaultObject(String message, String value, int status_code) {
        this.message = message;
        this.value = value;
        this.status_code = status_code;
    }

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getStatusCode() {
        return status_code;
    }

    public void setStatusCode(int status_code) {
        this.status_code = status_code;
    }
}
