package com.personApi.personApi.Exceptions;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented // Aqui vou documentar no java, pa que quando eu comece a escrever já apareça
@Target(ElementType.FIELD)  // Escolhendo onde irei usar a anotação, se é um campo, uma class ou método
@Constraint(validatedBy = {ExistCpfValidator.class}) // Indica qual class faz a validação
@Retention(RetentionPolicy.RUNTIME) // Define o tempo que será executada

public @interface ExistCpf {

    String message() default"Já existe esse cpf";
    Class <?> []  groups() default{};
    Class <? extends Payload>[]  payload() default{};

}
