package com.storemanager.api.exceptions.messages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomNotFoundExceptionError extends RuntimeException {
    public CustomNotFoundExceptionError(String message) {
        super(message);
    }
}
