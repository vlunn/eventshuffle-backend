package com.vlunn.eventshuffle.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Service-wide exception handling: defines handlers for all exceptions thrown
 * in the application.
 * 
 * NB: Since the ErrorResponses are sent to the outside world, they should not
 * give out too much information about the internal workings of the application.
 */
@ControllerAdvice
public class ShuffleExceptionHandler {
    
    final static Logger logger = LoggerFactory.getLogger(ShuffleExceptionHandler.class);

    @ExceptionHandler(value = NotImplementedException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public @ResponseBody
    ErrorResponse handleNotImplementedException(final NotImplementedException exception) { 
        logger.error("Called endpoint that has not yet been implemented.", exception);
        return new ErrorResponse(HttpStatus.NOT_IMPLEMENTED, exception.getMessage());
    }

}
