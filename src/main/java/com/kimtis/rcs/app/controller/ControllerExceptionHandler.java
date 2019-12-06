package com.kimtis.rcs.app.controller;

import com.kimtis.rcs.app.exception.ResourceAlreadyExistException;
import com.kimtis.rcs.app.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public GenericResponse<Void> resourceNotFound(RuntimeException ex) {
        GenericResponse<Void> resp = new GenericResponse<>();
        resp.setTimestamp(new Date());
        resp.setStatus(HttpStatus.NOT_FOUND.value());
        resp.setError(HttpStatus.NOT_FOUND.name());
        resp.setMessage(ex.getMessage());
        return resp;
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public GenericResponse<Void> resourceAlreadyExist(RuntimeException ex) {
        GenericResponse<Void> resp = new GenericResponse<>();
        resp.setTimestamp(new Date());
        resp.setStatus(HttpStatus.CONFLICT.value());
        resp.setError(HttpStatus.CONFLICT.name());
        resp.setMessage(ex.getMessage());
        return resp;
    }
}
