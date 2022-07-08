package com.storemanager.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomExceptionError {
    private Integer status;
    private LocalDateTime dateTime;
    private String titleError;
    private List<Field> fields;

    @Getter
    @AllArgsConstructor
    public static class Field {
        private String fieldName;
        private String fieldMessage;
    }
}
