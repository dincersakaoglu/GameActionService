package com.example.gameactionservice.exception;

public class NotSupportedActionTypeException extends RuntimeException{
    public NotSupportedActionTypeException(String message) {
        super(message);
    }
}
