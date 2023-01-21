package com.ectimel.springdemo.rest;

import java.time.LocalTime;

public class CustomerErrorResponse {
    private int status;
    private String message;
    private LocalTime currentTime;

    public CustomerErrorResponse() {
    }

    public CustomerErrorResponse(int status, String message, LocalTime currentTime) {
        this.status = status;
        this.message = message;
        this.currentTime = currentTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }
}
