package com.tstcore.easybank.exceptions;

import com.tstcore.easybank.payloads.ErrorDetails;
import com.tstcore.easybank.utils.DateUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //-- handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
    //-- handle user not created exceptions
    @ExceptionHandler(UserNotCreatedException.class)
    public ResponseEntity<ErrorDetails> handleUserNotCreatedException(UserNotCreatedException exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"An exception occurred due to "+ exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // -- handle the easy bank api exception
    @ExceptionHandler(EasyBankAPIException.class)
    public ResponseEntity<ErrorDetails> handleBlogAPIException(EasyBankAPIException exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
    //-- handle global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // -- handle the invalid method argument exception
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String message = ((FieldError)error).getDefaultMessage();
                    errors.put(fieldName,message);
        });
        errors.put("timestamp", DateUtil.getDateFormat());
        errors.put("http-status",HttpStatus.BAD_REQUEST.toString());
        errors.put("request",request.getContextPath());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
