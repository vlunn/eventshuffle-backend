package com.vlunn.eventshuffle.exception;

import lombok.Getter;

/**
 * Custom exception to indicate that a call was made to piece of code that 
 * is not implemented yet.
 */
public class NotImplementedException extends RuntimeException {
    
    @Getter
    private String message;

    public NotImplementedException() { }

    public NotImplementedException(final String message) {
        super(message);
        this.message = message;
    }

}
