package com.example.wheather_api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(WeatherException.class)
    public ResponseEntity<Map<String, Object>> handleWeatherException(
            WeatherException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", 400);
        response.put("error", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
            ConstraintViolationException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", 400);
        response.put("error", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
