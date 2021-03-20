package com.personApi.personApi.service;


import com.personApi.personApi.dto.MensageResponseDto;
import com.personApi.personApi.dto.PersonDto;
import com.personApi.personApi.entity.Person;
import com.personApi.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MensageResponseDto createPerson(@RequestBody PersonDto personDto){
        Person savedPerson = personRepository.save(personDto.toModel());
        return MensageResponseDto
                .builder()
                .message("Created person with id" + savedPerson.getId())
                .build();
    }

    public List<PersonDto> listAll() {
        List<Person> allPeople = personRepository.findAll();
        PersonDto personDto;
        return allPeople.stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }
}
