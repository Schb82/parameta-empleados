package com.parameta.empleado.DTOs;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*@Documented
@Constraint(validatedBy = BirthdateValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)*/

@Constraint(validatedBy = BirthdateValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented


public @interface birthdateConstraint {

    String message() default "fecha de nacimiento invalida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
