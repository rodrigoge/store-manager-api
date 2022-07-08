package com.storemanager.api.models.enums;

import lombok.Getter;

@Getter
public enum PeopleTypeEnum {
    Admin("Administrador"),
    Employee("Funcionário"),
    Client("Cliente");

    private final String description;

    PeopleTypeEnum(String description) {
        this.description = description;
    }
}
