package com.example.peoplewebservisedemo.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String msg) {
        super(msg);
    }
}
