package com.example.dancemeet.exception;

public class DancerNotFoundException extends RuntimeException{
    private static final String message = "Dancer not found";

    public DancerNotFoundException(){
        super(message);
    }
}
