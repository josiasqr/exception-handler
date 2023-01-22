package com.pe.exceptionhandler.exception.controladvice;

import com.pe.exceptionhandler.exception.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(NotFoundControlAdvice.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorDTO> handlerNotFoundException(NotFoundControlAdvice ex) {
    ErrorDTO errorDTO = new ErrorDTO(ex.getCode(), ex.getMessage());
    
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }
}
