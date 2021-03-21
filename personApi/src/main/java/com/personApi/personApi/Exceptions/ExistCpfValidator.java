package com.personApi.personApi.Exceptions;

import com.personApi.personApi.entity.Person;
import com.personApi.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ExistCpfValidator implements ConstraintValidator<ExistCpf,String> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void initialize(ExistCpf constraintAnnotation) {

    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
       Optional<Person> person = personRepository.findByCpf(cpf);

       if(person.isEmpty())
           return true;

        return false;
    }
}
