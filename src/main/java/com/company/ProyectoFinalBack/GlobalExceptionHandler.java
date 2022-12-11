package com.company.ProyectoFinalBack;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allError(Exception ex, WebRequest req){
        LOGGER.error(ex.getMessage());
        return new ResponseEntity("ExceptionHandler Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
