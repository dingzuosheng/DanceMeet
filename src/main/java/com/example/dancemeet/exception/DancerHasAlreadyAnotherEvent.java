package com.example.dancemeet.exception;

public class DancerHasAlreadyAnotherEvent extends RuntimeException{
    private static final String MESSAGE = "Dancer has already for this time joined another event";

    public DancerHasAlreadyAnotherEvent(){
        super(MESSAGE);
    }
}
