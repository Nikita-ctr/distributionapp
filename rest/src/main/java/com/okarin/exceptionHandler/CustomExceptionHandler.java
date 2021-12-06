package com.okarin.exceptionHandler;

import com.okarin.exceptions.DeveloperNotFoundExeption;
import com.okarin.exceptions.ProjectNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DeveloperNotFoundExeption.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(DeveloperNotFoundExeption e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProjectNotFoundExeption.class)
    public ResponseEntity<Object> handleDepartmentNotFoundException(ProjectNotFoundExeption e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}