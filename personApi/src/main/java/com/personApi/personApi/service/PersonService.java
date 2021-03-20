package com.personApi.personApi.service;


import com.personApi.personApi.dto.MensageResponseDto;
import com.personApi.personApi.entity.Person;
import com.personApi.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MensageResponseDto createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MensageResponseDto
                .builder()
                .message("Created person with id" + savedPerson.getId())
                .build();
    }
}
