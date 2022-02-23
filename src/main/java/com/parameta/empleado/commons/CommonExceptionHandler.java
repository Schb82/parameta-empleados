package com.parameta.empleado.commons;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice 
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {
    /*
   @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handlerException(NoSuchElementException exc){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return buildResponseEntity(httpStatus, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handlerException(DuplicateKeyException exc){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return buildResponseEntity(httpStatus, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handlerException(IllegalArgumentException exc){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return buildResponseEntity(httpStatus, exc);
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException exc){
         HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return buildResponseEntity(httpStatus,new RuntimeException("Argumento Invalido"));
    }*/

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handlerException(IllegalArgumentException exc){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return buildResponseEntity(httpStatus, exc);
    }

    @ExceptionHandler
    public final ResponseEntity<ErrorResponse> handleAllExceptions(InvalidDataException ex, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        return buildResponseEntity(
                httpStatus,
                new RuntimeException("Argumento Invalido"),
                ex.getResult().getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList()));
    }


    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc){
        return buildResponseEntity(httpStatus,exc,null);
    }


    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc, List<String> errors) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage("PARAMETA-");
        error.setStatus(httpStatus.value());
        error.setTimestamp(new Date());
        error.setErrors(Objects.nonNull(errors)? errors : Arrays.asList(exc.getMessage()));

        return new ResponseEntity<>(error,httpStatus);
    }

}

