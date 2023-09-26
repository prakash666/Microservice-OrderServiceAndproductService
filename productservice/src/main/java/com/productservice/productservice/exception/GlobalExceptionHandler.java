package com.productservice.productservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DefaultException.class)
    public String DefaultException(DefaultException exception){
    return exception.getMessage();
    }
}
