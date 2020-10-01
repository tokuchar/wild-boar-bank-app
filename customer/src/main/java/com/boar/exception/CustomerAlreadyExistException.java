package com.boar.exception;

public class CustomerAlreadyExistException extends Throwable {
    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
