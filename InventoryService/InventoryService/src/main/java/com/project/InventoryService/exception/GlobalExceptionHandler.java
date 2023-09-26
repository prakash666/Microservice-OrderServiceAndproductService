package com.project.InventoryService.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(DefaultException.class)
    public String DefaultExceptionHandler(DefaultException vo){
        return vo.getMessage();
    }




}
