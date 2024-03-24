package com.in28minutes.rest.webservices.restfulwebservices.exception;

import com.in28minutes.rest.webservices.restfulwebservices.User.UserNotFoundException;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends HandlerExceptionResolverComposite {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    ErrorDetails exceptionResponse = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
    ErrorDetails exceptionResponse = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  // @ExceptionHandler(MethodArgumentNotValidException.class)
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    ErrorDetails exceptionResponse = new ErrorDetails(new Date(), "Validation Failed",
        ex.getBindingResult().toString());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  // @Override
  // protected ResponseEntity<Object> handleMethodArgumentNotValid(
  // MethodArgumentNotValidException ex,
  // HttpHeaders headers,
  // HttpStatus status,
  // WebRequest request) {
  // ErrorDetails exceptionResponse = new ErrorDetails(new Date(), "Validation
  // Failed",
  // ex.getBindingResult().toString());
  // return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  // }

}

// @Override @ExceptionHandler(MethodArgumentNotValidException.class)
// @ExceptionHandler(MethodArgumentNotValidException.class)
// @Override
/*
 * protected ResponseEntity<Object>
 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
 * HttpHeaders headers, HttpStatus status, WebRequest request) {
 * 
 * @SuppressWarnings("null")
 * ErrorDetails exceptionResponse = new ErrorDetails(
 * LocalDateTime.now(),
 * "Validation Failed",
 * ex.getErrorCount() + ex.getFieldError().getDefaultMessage() //
 * .getDefaultMessage()
 * ); // ex.getBindingResult().toString());
 * // System.out.println(exceptionResponse);
 * ex.getFieldErrors();
 * return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
 * }
 */