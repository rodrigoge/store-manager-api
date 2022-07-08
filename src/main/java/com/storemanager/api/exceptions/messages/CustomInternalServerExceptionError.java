package com.storemanager.api.exceptions.messages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomInternalServerExceptionError extends RuntimeException {
    public CustomInternalServerExceptionError(String message) {
        super(message);
    }
}
