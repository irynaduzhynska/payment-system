package com.example.payment_system.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String password;
    private long units;
    private String accountNumber;
}
