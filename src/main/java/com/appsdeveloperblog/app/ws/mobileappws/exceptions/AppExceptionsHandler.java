package com.appsdeveloperblog.app.ws.mobileappws.exceptions;

import com.appsdeveloperblog.app.ws.mobileappws.ui.model.responseEntity.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    // 1.
//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
//        return  new ResponseEntity<>(  // place debug point
//                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object>handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return  new ResponseEntity<>(  // place debug point
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    //3. Handle a Specific Exception
//    /*@ExceptionHandler(value = {NullPointerException.class})
//    public ResponseEntity<Object>handNullPointerException(NullPointerException ex, WebRequest request) {
//        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
//        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();
//
//        ErrorMessage errorMessage= new ErrorMessage(new Date(), ex.getLocalizedMessage());
//        return  new ResponseEntity<>(  // place debug point
//                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }*/
//
    //4. Catch More than One Exception with One Method
//    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
//    public ResponseEntity<Object>handleSpecificException(Exception ex, WebRequest request) {
//        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
//        if(errorMessageDescription ==null) errorMessageDescription =ex.toString();
//
//        ErrorMessage errorMessage= new ErrorMessage(new Date(), ex.getLocalizedMessage());
//        return  new ResponseEntity<>(  // place debug point
//                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); }

    //2. Throw and Handle your own  Custom Exception
//    @ExceptionHandler(value = {UserServiceException.class})
//    public ResponseEntity<Object>handleUserServiceException(UserServiceException ex, WebRequest request) {
//        String errorMessageDescription = ex.getLocalizedMessage();  // Debug point
//       if(errorMessageDescription ==null) errorMessageDescription =ex.toString();
//      else {
//           ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
//       }
//        return  new ResponseEntity<>(  // place debug point
//                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
