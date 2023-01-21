package com.ectimel.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class CustomerRestExceptionHandler {


    //wrong id exception
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception){

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();

        customerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customerErrorResponse.setMessage(exception.getMessage());
        customerErrorResponse.setCurrentTime(LocalTime.now());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
    }

    //any exception, for example text instead of numbers
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exception){

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();

        customerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customerErrorResponse.setMessage(exception.getMessage());
        customerErrorResponse.setCurrentTime(LocalTime.now());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
