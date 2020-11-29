package com.hsl.realestatelisitng.validation;

import com.hsl.realestatelisitng.model.Listing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
class ErrorHandlingControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<FieldError> errors= e.getBindingResult().getFieldErrors();
        List<String> errorList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(errors)){
            errors.forEach( fError->{
                System.out.println(fError.getField()+":"+fError.getDefaultMessage());
                errorList.add(fError.getField()+":"+fError.getDefaultMessage());
            });
        }
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.setViolations(errorList);
        return error;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Listing> handleNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Or HttpStatus.NO_CONTENT
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}