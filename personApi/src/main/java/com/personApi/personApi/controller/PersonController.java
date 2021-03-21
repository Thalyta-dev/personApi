package com.personApi.personApi.controller;

import com.personApi.personApi.dto.MensageResponseDto;
import com.personApi.personApi.dto.PersonDto;
import com.personApi.personApi.Exceptions.PersonNotFoundException;
import com.personApi.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.format.DateTimeFormatter.ofLocalizedDate;

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
    public MensageResponseDto createPerson( @RequestBody @Valid PersonDto personDto){
        return  personService.createPerson(personDto);
    }

    @GetMapping
    public List<PersonDto> listAll(){
        return personService.listAll();

    }

    @GetMapping("/{id}")
    public PersonDto findId(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) throws PersonNotFoundException {
        personService.deletePerson(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAllPerson()  {
        personService.deleteAllPerson();
    }

    @GetMapping("/birthDate")
    public PersonDto findBirthDate(@RequestParam(value="birthDate")String birthDate) throws PersonNotFoundException {
        return personService.personBirthDate(LocalDate.parse(birthDate));
    }

}
