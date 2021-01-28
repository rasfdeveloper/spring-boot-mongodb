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

        String msg = "Não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                msg,
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(error);

    }

}
