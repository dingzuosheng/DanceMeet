package com.example.dancemeet.exception;

public class NotAvailableException extends RuntimeException{
    private static final String MESSAGE = "Time is not available";

    public NotAvailableException(){
        super(MESSAGE);
    }
}
