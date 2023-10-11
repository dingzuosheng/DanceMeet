package com.example.dancemeet.exception;

public class DancerAlreadyExistsException extends RuntimeException{
    private static final String message = "The dancer with this email address already exists";

    public DancerAlreadyExistsException(){
        super(message);
    }
}
