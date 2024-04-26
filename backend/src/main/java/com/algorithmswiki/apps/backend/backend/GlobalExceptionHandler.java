package com.algorithmswiki.apps.backend.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algorithmswiki.apps.backend.backend.Object.ErrorObject;
import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> hanleMissingParameter(MissingServletRequestParameterException ex) throws JsonProcessingException {
        String parameterName = ex.getParameterName();
        String errorMessage = "Parameter " + parameterName + " is required";

        ErrorObject errorObject = new ErrorObject(500, errorMessage);

        return new ResponseEntity<>(JSONHelper.toJSON(errorObject).toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
