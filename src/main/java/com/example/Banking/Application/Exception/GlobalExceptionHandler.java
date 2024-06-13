package com.example.Banking.Application.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AccountNumberDuplicateException.class)
    public ResponseEntity<ErrorDetails> handleException(AccountNumberDuplicateException ex, WebRequest request){
      ErrorDetails errorDetails = new ErrorDetails(
              LocalDateTime.now(),
              ex.getMessage(),
              request.getDescription(false),
              "Cant enter duplicate AccountNumber"

      );
return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);

    }
}
