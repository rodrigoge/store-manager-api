package com.storemanager.api.services;


import com.storemanager.api.converters.PeopleConverter;
import com.storemanager.api.dto.PeopleDTO;
import com.storemanager.api.models.entities.People;
import com.storemanager.api.models.enums.PeopleTypeEnum;
import com.storemanager.api.repositories.PeopleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceTest {
    @InjectMocks
    PeopleService peopleService;

    @Mock
    PeopleRepository peopleRepository;

    @Mock
    PeopleConverter peopleConverter;

    @Test
    @DisplayName("should register people")
    public void registerPeople(){
        OffsetDateTime offsetDateTime = OffsetDateTime.of(
                1994,
                9,
                3,
                0,
                0,
                0,
                0,
                ZoneOffset.UTC
        );

        PeopleDTO peopleDTO = new PeopleDTO(
                1L,
                "John Admin",
                "john@test.com",
                "12345678",
                offsetDateTime,
                "55123456789",
                null,
                PeopleTypeEnum.Admin
        );

        peopleService.register(peopleDTO);

        Mockito.verify(peopleConverter).convertingToPeople(peopleDTO);
        Mockito.verify(peopleRepository).save(peopleConverter.convertingToPeople(peopleDTO));
    }
}
