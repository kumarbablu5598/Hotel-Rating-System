package com.hotel.hotel.exceptions;

import com.hotel.hotel.model.ApiResponse;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
         String massage = ex.getMessage();
         ApiResponse response = ApiResponse.builder().massage(massage).success(true).status(HttpStatus.NOT_FOUND).build();
         return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

    }
}
