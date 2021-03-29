package com.example.payment_system.service;

import com.example.payment_system.entity.PersonalAccount;

public interface PersonalAccountService {
    PersonalAccount get(Long id);

    PersonalAccount add(PersonalAccount account);

    PersonalAccount findByAccountNumber(String accountNum);
}
