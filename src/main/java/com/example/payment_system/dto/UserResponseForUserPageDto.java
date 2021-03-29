package com.example.payment_system.dto;

import lombok.Data;

@Data
public class UserResponseForUserPageDto {
    private Long id;
    private String email;
    private String accountNumber;
}
