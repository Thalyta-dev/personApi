package com.personApi.personApi.dto;

import com.personApi.personApi.Exceptions.ExistCpf;
import com.personApi.personApi.entity.Person;
import com.personApi.personApi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class PersonDto {


    private  Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;


    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    private LocalDate birthDate;

    @ExistCpf
    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    @Valid
    private List<Phone> phoneList;


    public Person toModel(){

        Person person = new Person();
        person.setFirstName(this.getFirstName());
        person.setLastName(this.getLastName());
        person.setCpf(this.getCpf());
        person.setBirthDate(this.getBirthDate());
        person.setPhoneList(this.getPhoneList());

        return person;
    }


    public PersonDto(Person person){

        this.setId(person.getId());
        this.setFirstName(person.getFirstName());
        this.setLastName(person.getLastName());
        this.setCpf(person.getCpf());
        this.setBirthDate(person.getBirthDate());
        this.setPhoneList(person.getPhoneList());

    }

}
