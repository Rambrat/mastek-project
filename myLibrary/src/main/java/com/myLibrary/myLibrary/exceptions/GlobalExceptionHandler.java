package com.myLibrary.myLibrary.exceptions;

import com.myLibrary.myLibrary.helper.ApiResponseMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMsg> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){

        ApiResponseMsg apiResponseMsg = ApiResponseMsg.builder()
                .message(resourceNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .success(false).build();

        return new ResponseEntity<>(apiResponseMsg,HttpStatus.NOT_FOUND);
    }
}
