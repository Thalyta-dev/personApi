package com.personApi.personApi.repository;

import com.personApi.personApi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByBirthDate(LocalDate birthDate);

    //Feito com sql, na mão. Usada geralmente para consultas mais complexas
    @Query("SELECT P FROM Person P where P.birthDate = :birthDate")
    Person findPersonBirthDate(LocalDate birthDate);

    Optional<Person> findByCpf(String cpf);
}
