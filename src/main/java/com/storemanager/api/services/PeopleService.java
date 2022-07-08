package com.storemanager.api.services;

import com.storemanager.api.converters.PeopleConverter;
import com.storemanager.api.dto.PeopleDTO;
import com.storemanager.api.exceptions.messages.CustomNotFoundExceptionError;
import com.storemanager.api.models.entities.People;
import com.storemanager.api.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private PeopleConverter peopleConverter;

    /**
     * @return a list of objects converted in People Dto object
     */
    @Transactional
    public Set<PeopleDTO> findAll() {
        return peopleConverter.convertingToListPeopleDTO(peopleRepository.findAll());
    }

    /**
     * @param peopleDTO data transfer object referencing People object
     * @return data transfer people object converting People object
     */
    @Transactional
    public PeopleDTO register(PeopleDTO peopleDTO) {
        People people = peopleConverter.convertingToPeople(peopleDTO);
        peopleRepository.save(people);
        return peopleConverter.convertingToPeopleDTO(people);
    }

    /**
     *
     * @param peopleId identifier of people object
     * @param fields people fields used in update
     * @return people object updated
     */
    @Transactional
    public PeopleDTO update(Long peopleId, Map<Object, Object> fields){
        PeopleDTO peopleDTO = peopleConverter.convertingToPeopleDTO(peopleRepository.findById(peopleId)
                .orElseThrow(() -> new CustomNotFoundExceptionError("People Id Not Found.")));

        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(PeopleDTO.class, (String) k);

            if(field != null){
                field.setAccessible(true);
                ReflectionUtils.setField(field, peopleDTO, v);
            }
        });

        return this.register(peopleDTO);
    }

    /**
     *
     * @param peopleId identifier of people object
     */
    @Transactional
    public void delete(Long peopleId) {
        People people = peopleRepository.findById(peopleId)
                .orElseThrow(() -> new CustomNotFoundExceptionError("People Id Not Found."));

        if(people != null){
            peopleRepository.deleteById(peopleId);
        }
    }
}
