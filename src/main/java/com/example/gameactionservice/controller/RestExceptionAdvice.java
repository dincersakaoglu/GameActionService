package com.example.gameactionservice.controller;

import com.example.gameactionservice.exception.ExceptionResponseDto;
import com.example.gameactionservice.exception.NotSupportedActionTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionAdvice {

    @ExceptionHandler(value = NotSupportedActionTypeException.class)
    public ResponseEntity<ExceptionResponseDto> notSupportedActionStrategy(RuntimeException runtimeException) {
        return new ResponseEntity<>(
                ExceptionResponseDto.builder()
                        .message(runtimeException.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }


}