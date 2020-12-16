package com.boar.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;

@Slf4j
@ControllerAdvice
public class AccountExceptionHandler {
    public static final String EXCEPTION_MESSAGE = "exception";
    public static final String RESPONSE_MESSAGE = "message";

    @ExceptionHandler(AccountAlreadyExistException.class)
    public ResponseEntity<Object> accountAlreadyExistException(AccountAlreadyExistException exception) {
        log.error(EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, exception.getMessage());
                }},
                HttpStatus.CONFLICT);
    }
    @ExceptionHandler(javax.security.auth.login.AccountNotFoundException.class)
    public ResponseEntity<Object> customerNotFoundException(AccountNotFoundException exception) {
        log.error(EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, exception.getMessage());
                }},
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error(EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(
                new HashMap<String, String>() {{
                    put(RESPONSE_MESSAGE, exception.getBindingResult().getFieldError().getDefaultMessage());
                }},
                HttpStatus.PRECONDITION_FAILED);
    }
}
