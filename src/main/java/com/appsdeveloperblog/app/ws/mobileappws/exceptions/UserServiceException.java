package com.appsdeveloperblog.app.ws.mobileappws.exceptions;

import java.io.Serial;

public class UserServiceException extends  RuntimeException{

     @Serial
     private static final long serialVersionUID = -3297240201888358523L;

    public UserServiceException(String message)
    {
        super(message);
    }
}
