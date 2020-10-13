package com.boar.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;

@Slf4j
@ControllerAdvice
public class CustomerExceptionHandler {
    public static final String EXCEPTION_MESSAGE = "exception: ";
    public static final String RESPONSE_MESSAGE = "message";

    @ExceptionHandler(IdentityDocumentException.class)
    public ResponseEntity<Object> identityDocumentIsWrong(IdentityDocumentException exception) {
        log.error(EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, exception.getMessage());
                }},
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationException(ConstraintViolationException exception) {
        log.error(EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, exception.getMessage());
                }},
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<Object> customerAlreadyExistsException(CustomerAlreadyExistException exception) {
        log.error(EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, exception.getMessage());
                }},
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> customerNotFoundException(CustomerNotFoundException exception) {
        log.error(EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, exception.getMessage());
                }},
                HttpStatus.NOT_FOUND);
    }
}
