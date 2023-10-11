package com.example.dancemeet.exception;

public class DepositNotEnoughException extends RuntimeException{
    private static final String MESSAGE = "Your deposit is not enough, please charge it in time";

    public DepositNotEnoughException(){
        super(MESSAGE);
    }
}
