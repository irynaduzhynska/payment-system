package com.example.payment_system.dto;

import com.example.payment_system.lib.UnitsConstraint;
import lombok.Data;

@Data
public class AccountDto {
    private String accountNumber;
    @UnitsConstraint
    private long units;
}
