package com.example.onlinelearnplatfrom.exception;

public class DbRecordNotFoundException extends RuntimeException {

    public DbRecordNotFoundException(String message){
        super(message);
    }
    public DbRecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
