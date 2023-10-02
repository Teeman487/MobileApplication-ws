package com.appsdeveloperblog.app.ws.mobileappws.Exceptions;

import com.appsdeveloperblog.app.ws.mobileappws.ui.modelresponse.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
/*public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object>handleAnyException(Exception ex, WebRequest request) {
        return  new ResponseEntity<>(  // place debug point
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {   // Custom Error --


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object>handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return  new ResponseEntity<>(  // place debug point
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // Handle a Specific Exception
    /*@ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object>handNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return  new ResponseEntity<>(  // place debug point
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})  // Catch More than One Exception with One Method
    public ResponseEntity<Object>handleSpecificException(Exception ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return  new ResponseEntity<>(  // place debug point
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); }

    // Throw and Handle your own  Custom Exception
   /* @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object>handleUserServiceException(NullPointerException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return  new ResponseEntity<>(  // place debug point
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
