package com.igc.productinventorymanager.exception;

import com.igc.productinventorymanager.response.Response;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
   public ResponseEntity<?> productNotFoundException(ProductNotFoundException pNotException) {
        return new ResponseEntity<>(new Response("The ID you have provided is not available.", HttpStatus.NOT_FOUND, null), HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(ConstraintViolationException.class)
   public ResponseEntity<?> validationError(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> constraintViolation = constraintViolationException.getConstraintViolations();
        Map<String, String> errorMap = new HashMap<String, String>();
        for(ConstraintViolation cv : constraintViolation) {
                    logger.info(cv.getPropertyPath()+ "=" +cv.getMessage());
                    errorMap.put(cv.getPropertyPath().toString(), cv.getMessage());
                }

               return new ResponseEntity<>(new Response("Error in data", HttpStatus.BAD_REQUEST, errorMap), HttpStatus.BAD_REQUEST);
   }



}
