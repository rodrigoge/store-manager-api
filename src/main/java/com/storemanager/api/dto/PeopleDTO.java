package com.storemanager.api.dto;

import com.storemanager.api.models.enums.PeopleTypeEnum;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO extends RepresentationModel<PeopleDTO> {

    private Long key;

    private String peopleName;

    private String peopleEmail;

    private String peoplePassword;

    private OffsetDateTime peopleBirthday;

    private String peoplePhone;

    private byte[] peopleAvatar;

    private PeopleTypeEnum peopleType;
}
