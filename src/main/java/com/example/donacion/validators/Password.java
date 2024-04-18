package com.example.donacion.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Target(FIELD)
@Constraint(validatedBy = PaswordValidation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

	String message() default "Contraseña inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};	
}
