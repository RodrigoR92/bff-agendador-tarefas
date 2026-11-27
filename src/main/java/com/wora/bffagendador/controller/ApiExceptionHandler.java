package com.wora.bffagendador.controller;


import com.wora.bffagendador.infrastructure.exception.ConflictExcepition;
import com.wora.bffagendador.infrastructure.exception.BusinessExeption;
import com.wora.bffagendador.infrastructure.exception.ForbiddenException;
import com.wora.bffagendador.infrastructure.exception.IllegalArgumentException;
import com.wora.bffagendador.infrastructure.exception.ResourceNotFoundException;
import com.wora.bffagendador.infrastructure.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BusinessExeption.class)
    public ResponseEntity<String> handlerBusinessException(BusinessExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<String> handlerForbiddenException(ForbiddenException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ConflictExcepition.class)
    public ResponseEntity<String> handlerConflictException(ConflictExcepition ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handlerUnauthorizedException(UnauthorizedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
