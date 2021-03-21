package com.personApi.personApi.service;


import com.personApi.personApi.Exceptions.PersonNotFoundException;
import com.personApi.personApi.dto.MensageResponseDto;
import com.personApi.personApi.dto.PersonDto;
import com.personApi.personApi.entity.Person;
import com.personApi.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
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

    public PersonDto findById(Long id) throws PersonNotFoundException {
       // Optional<Person> pessoa =  personRepository.findById(id);
        Person person =  personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
        return new PersonDto(person);
    }


    public void deletePerson(Long id) throws PersonNotFoundException {
        this.findById(id);
       personRepository.deleteById(id);
    }

    public void deleteAllPerson() {
        personRepository.deleteAll();
    }

    public PersonDto personBirthDate(LocalDate birthDate) throws PersonNotFoundException {
        Person person = personRepository.findByBirthDate(birthDate).orElseThrow(() -> new PersonNotFoundException(birthDate));
        return new PersonDto(person);

    }

    public MensageResponseDto updateById(Long id, PersonDto personDto) throws PersonNotFoundException {
        Person up = this.findById(id).toModel();
        Person person =  personDto.toModel();
        person.setId(id);
        personRepository.save(person);
        return MensageResponseDto
                .builder()
                .message("An person with id"  + person.getId()+ "has been modified")
                .build();
    }
}
