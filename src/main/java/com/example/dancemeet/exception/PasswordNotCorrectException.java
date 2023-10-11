package com.example.dancemeet.exception;

public class PasswordNotCorrectException extends RuntimeException{
    private static final String message = "Password is not correct";

    public PasswordNotCorrectException(){
        super(message);
    }
}
