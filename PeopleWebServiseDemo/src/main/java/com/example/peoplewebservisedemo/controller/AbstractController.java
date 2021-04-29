package com.example.peoplewebservisedemo.controller;

import com.example.peoplewebservisedemo.dto.ErrorDTO;
import com.example.peoplewebservisedemo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class AbstractController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleNotFoundException(NotFoundException e) {
        return new ErrorDTO(new Date(), "Not found error", e.getMessage());
    }
}
