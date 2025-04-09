package com.scaler.productservice.exceptions;


import com.scaler.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundExceptions.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundExceptions notFoundException) {

        return new ResponseEntity(
                new ExceptionDto(notFoundException.getMessage(),HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
        );
    }

}
