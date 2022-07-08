package com.storemanager.api.exceptions;

import com.storemanager.api.exceptions.messages.CustomBadRequestExceptionError;
import com.storemanager.api.exceptions.messages.CustomInternalServerExceptionError;
import com.storemanager.api.exceptions.messages.CustomNotFoundExceptionError;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders httpHeaders,
            @NonNull HttpStatus httpStatus,
            @NonNull WebRequest webRequest
    ) {
        List<CustomExceptionError.Field> fields = new ArrayList<>();

        for (ObjectError obj : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) obj).getField();
            String fieldMessage = obj.getDefaultMessage();

            fields.add(new CustomExceptionError.Field(fieldName, fieldMessage));
        }

        CustomExceptionError error = new CustomExceptionError();
        error.setStatus(httpStatus.value());
        error.setDateTime(LocalDateTime.now());
        error.setFields(fields);

        return handleExceptionInternal(ex, error, httpHeaders, httpStatus, webRequest);
    }

    @ExceptionHandler(CustomInternalServerExceptionError.class)
    public ResponseEntity<Object> handleCustomInternalServerErrorException(
            CustomInternalServerExceptionError ex, WebRequest webRequest) {

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        CustomExceptionError customExceptionError = new CustomExceptionError();
        customExceptionError.setStatus(httpStatus.value());
        customExceptionError.setDateTime(LocalDateTime.now());
        customExceptionError.setTitleError(ex.getMessage());

        return handleExceptionInternal(ex, customExceptionError, new HttpHeaders(), httpStatus, webRequest);
    }

    @ExceptionHandler(CustomBadRequestExceptionError.class)
    public ResponseEntity<Object> handleCustomBadRequestErrorException(
            CustomBadRequestExceptionError ex, WebRequest webRequest) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        CustomExceptionError customExceptionError = new CustomExceptionError();
        customExceptionError.setStatus(httpStatus.value());
        customExceptionError.setDateTime(LocalDateTime.now());
        customExceptionError.setTitleError(ex.getMessage());

        return handleExceptionInternal(ex, customExceptionError, new HttpHeaders(), httpStatus, webRequest);
    }

    @ExceptionHandler(CustomNotFoundExceptionError.class)
    public ResponseEntity<Object> handleCustomBadRequestErrorException(
            CustomNotFoundExceptionError ex, WebRequest webRequest) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomExceptionError customExceptionError = new CustomExceptionError();
        customExceptionError.setStatus(httpStatus.value());
        customExceptionError.setDateTime(LocalDateTime.now());
        customExceptionError.setTitleError(ex.getMessage());

        return handleExceptionInternal(ex, customExceptionError, new HttpHeaders(), httpStatus, webRequest);
    }
}
