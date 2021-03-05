package com.renatofranco.workshopmongo.controller.exception;

import com.renatofranco.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNodFound(ObjectNotFoundException e, HttpServletRequest request){

        String msg = "Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(e.getMessage());

        return ResponseEntity.status(status).body(error);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException e, HttpServletRequest request){

        String msg = "Bad Request";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(e.getMessage());

        return ResponseEntity.status(status).body(error);
    }

}
