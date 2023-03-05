package com.app.dto;

public class ErrorResponse {
    private int status;
    private String message;

    // Constructors, getters, and setters
    public ErrorResponse() {}
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
    
    
    
    // Other getters and setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
