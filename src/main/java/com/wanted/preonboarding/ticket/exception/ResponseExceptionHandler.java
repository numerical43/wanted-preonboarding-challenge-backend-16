package com.wanted.preonboarding.ticket.exception;

import com.wanted.preonboarding.core.domain.response.ResponseHandler;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseHandler<?>> handleNullPointerException(NullPointerException e) {
        log.error(e.getMessage());
        ResponseHandler<String> response = ResponseHandler.error(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseHandler<String>> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.getMessage());
        ResponseHandler<String> response = ResponseHandler.error(HttpStatus.BAD_REQUEST, e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseHandler<?>> handleEntityNotFoundException(EntityNotFoundException e) {
        log.error((e.getMessage()));
        ResponseHandler<String> response = ResponseHandler.error(HttpStatus.NOT_FOUND, e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
