package com.clinicApp.clinicApp.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    private HttpStatus httpStatus;
    private String message;
    private LocalDateTime dateTime;


    public ErrorResponse(HttpStatus httpStatus,String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
