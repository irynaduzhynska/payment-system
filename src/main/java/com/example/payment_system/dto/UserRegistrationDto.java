package com.example.payment_system.dto;

import com.example.payment_system.lib.EmailConstraint;
import com.example.payment_system.lib.FieldsValueMatch;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@FieldsValueMatch(field = "password",
        fieldMatch = "repeatPassword")
public class UserRegistrationDto {
    @NotEmpty
    @EmailConstraint
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String repeatPassword;
}
