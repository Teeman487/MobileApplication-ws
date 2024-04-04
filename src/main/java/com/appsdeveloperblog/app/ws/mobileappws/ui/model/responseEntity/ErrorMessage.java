package com.appsdeveloperblog.app.ws.mobileappws.ui.model.responseEntity;

import java.util.Date;

// Return Custom Error Message Object
public class ErrorMessage {
    private Date timestamp;
    private String message;

    public ErrorMessage() {}

    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
