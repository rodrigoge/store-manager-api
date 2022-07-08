package com.storemanager.api.models.entities;

import com.storemanager.api.models.enums.PeopleTypeEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@Entity
@Table(name = "people")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 2, max = 255)
    @NotBlank(message = "Nome do produto é obrigatório.")
    private String name;

    @Column
    @Size(min = 2, max = 255)
    @NotBlank(message = "E-mail é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @Column
    @Size(min = 3, max = 10)
    @NotBlank(message = "Senha é obrigatória.")
    private String password;

    @Column
    private OffsetDateTime birthday;

    @Column
    @Size(min = 10, max = 11)
    private String phone;

    @Column
    private byte[] avatar;

    @Column
    @Enumerated(EnumType.STRING)
    private PeopleTypeEnum type;
}
