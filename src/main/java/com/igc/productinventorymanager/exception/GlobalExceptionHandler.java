package com.igc.productinventorymanager.exception;

import com.igc.productinventorymanager.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
   public ResponseEntity<?> productNotFoundException(ProductNotFoundException pNotException) {
        return new ResponseEntity<>(new Response("The ID you have provided is not available.", HttpStatus.NOT_FOUND, null), HttpStatus.NOT_FOUND);
   }


}
