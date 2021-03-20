package com.personApi.personApi.controller;

import com.personApi.personApi.dto.MensageResponseDto;
import com.personApi.personApi.entity.Person;
import com.personApi.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/person")
@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MensageResponseDto createPerson( @RequestBody Person person){
        return  personService.createPerson(person);
    }


}
