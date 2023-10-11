package com.example.dancemeet.exception;

public class EventAlreadyExistException extends RuntimeException {
    private static final String MESSAGE = "This event exists already";

    public EventAlreadyExistException(){
        super(MESSAGE);
    }
}
