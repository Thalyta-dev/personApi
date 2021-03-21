package com.personApi.personApi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(Long id) {
        super("Person not found id "+ id);
    }

    public PersonNotFoundException(LocalDate birthDate) {
        super("Person not found id "+ birthDate);
    }
}
