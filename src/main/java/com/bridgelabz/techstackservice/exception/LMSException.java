package com.bridgelabz.techstackservice.exception;

public class LMSException extends RuntimeException{
    private int statusCode;
    private String statusMessage;

    public LMSException(int statusCode, String statusMessage){
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
