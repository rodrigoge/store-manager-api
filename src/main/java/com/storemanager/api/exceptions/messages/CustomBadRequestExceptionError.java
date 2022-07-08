package com.storemanager.api.exceptions.messages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomBadRequestExceptionError extends RuntimeException {
    public CustomBadRequestExceptionError(String message) {
        super(message);
    }
}
