package com.example.peoplewebservisedemo.controller;
import com.example.peoplewebservisedemo.dto.ErrorDTO;
import com.example.peoplewebservisedemo.exception.BadRequestException;
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

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleBadRequestException(BadRequestException e){
        return new ErrorDTO(new Date(), "Bad request error", e.getMessage());
    }

 /*  @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleResourceNotFoundException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations ) {
            strBuilder.append(violation.getMessage()).append("\n");
        }
        return strBuilder.toString();
    }*/




}
