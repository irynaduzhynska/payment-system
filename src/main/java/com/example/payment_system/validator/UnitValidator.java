package com.example.payment_system.validator;

import com.example.payment_system.lib.UnitsConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UnitValidator implements ConstraintValidator<UnitsConstraint, Long> {

    @Override
    public boolean isValid(Long units, ConstraintValidatorContext constraintValidatorContext) {
        return units != null && units > 0;
    }
}
