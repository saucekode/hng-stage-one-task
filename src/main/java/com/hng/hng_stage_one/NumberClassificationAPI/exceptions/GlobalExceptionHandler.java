package com.hng.hng_stage_one.NumberClassificationAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NumClassException.class)
    public ResponseEntity<Map<String, Object>> handleGlobalExceptions(NumClassException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("number", ex.getNumber());
        response.put("error", ex.isError());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
