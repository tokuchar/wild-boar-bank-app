package com.boar.exception;

public class CustomerNotFoundException extends Throwable{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
