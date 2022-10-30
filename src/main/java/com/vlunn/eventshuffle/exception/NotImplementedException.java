package com.vlunn.eventshuffle.exception;

/**
 * Custom exception to indicate that a call was made to piece of code that 
 * is not implemented yet.
 */
public class NotImplementedException extends RuntimeException {
    
    private String message;

    public NotImplementedException() { }

    public NotImplementedException(final String message) {
        super(message);
        this.message = message;
    }

}
