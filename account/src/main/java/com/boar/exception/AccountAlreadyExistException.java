package com.boar.exception;

public class AccountAlreadyExistException extends Throwable {
    public AccountAlreadyExistException(String message) {
        super(message);
    }
}
