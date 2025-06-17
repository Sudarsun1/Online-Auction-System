package com.cts.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	
    // Handle specific exceptions
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidIdException(InvalidIdException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", System.currentTimeMillis());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", "Bad Request");
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", "/api/bid/place");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // Handle entity not found exceptions
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFound(EntityNotFoundException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", System.currentTimeMillis());
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());
        errorDetails.put("error", "Not Found");
        errorDetails.put("message", "The requested resource was not found. Please check the details and try again.");
        errorDetails.put("path", "/api/resource");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", System.currentTimeMillis());
        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetails.put("error", "Internal Server Error");
        errorDetails.put("message", "An unexpected error occurred. Please try again later.");
        errorDetails.put("path", "/api/generic");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", System.currentTimeMillis());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", "Bad Request");
        errorDetails.put("message", "Validation Errors: " + ex.getBindingResult().getFieldErrors().stream()
            .map(error -> error.getField() + " - " + error.getDefaultMessage())
            .reduce((msg1, msg2) -> msg1 + "; " + msg2).orElse(""));
        errorDetails.put("path", "/api/bid/place");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
 
}
