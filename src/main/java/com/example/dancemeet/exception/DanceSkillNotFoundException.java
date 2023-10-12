package com.example.dancemeet.exception;

public class DanceSkillNotFoundException extends RuntimeException{
    private static final String MESSAGE = "This dance skill is not available";
    public DanceSkillNotFoundException(){
        super(MESSAGE);
    }
}
