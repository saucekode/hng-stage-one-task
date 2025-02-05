package com.hng.hng_stage_one.NumberClassificationAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("number", "alphabet");
        response.put("error", true);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
