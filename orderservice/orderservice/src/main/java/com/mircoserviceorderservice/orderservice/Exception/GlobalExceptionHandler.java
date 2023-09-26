package com.mircoserviceorderservice.orderservice.Exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DefaultException.class)
    public String DefaultException(DefaultException vo){
        return vo.getMessage();
    }
}
