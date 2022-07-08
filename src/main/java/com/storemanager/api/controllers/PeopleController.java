package com.storemanager.api.controllers;

import com.storemanager.api.dto.PeopleDTO;
import com.storemanager.api.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/peoples")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    /**
     * @return a list objects of People DTO with Http status 200
     */
    @GetMapping
    public ResponseEntity<Set<PeopleDTO>> findPeoples() {
        return new ResponseEntity<>(peopleService.findAll(), HttpStatus.OK);
    }


    /**
     * @param peopleDTO a people Dto object being registered
     * @return object people registered and Http status 201
     */
    @PostMapping
    public ResponseEntity<PeopleDTO> register(@Valid @RequestBody PeopleDTO peopleDTO) {
        return new ResponseEntity<>(peopleService.register(peopleDTO), HttpStatus.ACCEPTED);
    }

    /**
     *
     * @param peopleId identifier of people object
     * @param fields people fields used in update
     * @return people object updated
     */
    @PatchMapping("/{peopleId}")
    public ResponseEntity<PeopleDTO> update(@Valid @PathVariable Long peopleId,
                                            @RequestBody Map<Object, Object> fields){
        return new ResponseEntity<>(peopleService.update(peopleId, fields), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{peopleId}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long peopleId){
       peopleService.delete(peopleId);
       return ResponseEntity.noContent().build();
    }
}
