package com.example.dancemeet.exception;


public class EventNotFoundException extends RuntimeException{
    private static final String MESSAGE = "This event is not found";

    public EventNotFoundException(){
        super(MESSAGE);
    }
}
