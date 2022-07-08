package com.storemanager.api.converters;

import com.storemanager.api.dto.PeopleDTO;
import com.storemanager.api.models.entities.People;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PeopleConverter {
    public PeopleDTO convertingToPeopleDTO(People people) {
        PeopleDTO peopleDTO = new PeopleDTO();

        peopleDTO.setKey(people.getId());
        peopleDTO.setPeopleName(people.getName());
        peopleDTO.setPeopleEmail(people.getEmail());
        peopleDTO.setPeoplePassword(people.getPassword());
        peopleDTO.setPeopleBirthday(people.getBirthday());
        peopleDTO.setPeoplePhone(people.getPhone());
        peopleDTO.setPeopleAvatar(people.getAvatar());
        peopleDTO.setPeopleType(people.getType());

        return peopleDTO;
    }

    public Set<PeopleDTO> convertingToListPeopleDTO(List<People> peoples) {
        Set<PeopleDTO> peoplesDTO = new HashSet<>();

        for (People people : peoples) {
            PeopleDTO peopleDTO = this.convertingToPeopleDTO(people);
            peoplesDTO.add(peopleDTO);
        }

        return peoplesDTO;
    }

    public People convertingToPeople(PeopleDTO peopleDTO) {
        People people = new People();

        people.setId(peopleDTO.getKey());
        people.setName(peopleDTO.getPeopleName());
        people.setEmail(peopleDTO.getPeopleEmail());
        people.setPassword(peopleDTO.getPeoplePassword());
        people.setBirthday(peopleDTO.getPeopleBirthday());
        people.setPhone(peopleDTO.getPeoplePhone());
        people.setAvatar(peopleDTO.getPeopleAvatar());
        people.setType(peopleDTO.getPeopleType());

        return people;
    }

    public Set<People> convertingToListPeople(List<PeopleDTO> peoplesDTO) {
        Set<People> peoples = new HashSet<>();

        for (PeopleDTO peopleDTO : peoplesDTO) {
            People people = this.convertingToPeople(peopleDTO);
            peoples.add(people);
        }

        return peoples;
    }
}
