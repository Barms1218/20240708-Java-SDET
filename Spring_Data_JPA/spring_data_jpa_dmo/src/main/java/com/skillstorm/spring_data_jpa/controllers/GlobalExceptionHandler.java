package com.skillstorm.spring_data_jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * Think of this like a giant try-catch surrounding your entire controllers
     * 
     * Specify the exceptions you want to catch and then you can change the HTTP response message
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationError(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
