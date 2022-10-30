package com.vlunn.eventshuffle.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
    
    private int statusCode;

    private String message;

    public ErrorResponse(final HttpStatus statusCode, final String message) {
        this.statusCode = statusCode.value();
        this.message = message;
    }

}
