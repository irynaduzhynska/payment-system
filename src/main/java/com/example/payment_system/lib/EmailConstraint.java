package com.example.payment_system.lib;

import com.example.payment_system.validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
    String message() default "Please, enter correct email!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
