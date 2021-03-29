package com.example.payment_system.lib;

import com.example.payment_system.validator.UnitValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UnitValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnitsConstraint {
    String message() default "Please, enter correct number of units!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
