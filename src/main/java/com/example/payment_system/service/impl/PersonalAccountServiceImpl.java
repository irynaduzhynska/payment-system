package com.example.payment_system.service.impl;

import com.example.payment_system.entity.PersonalAccount;
import com.example.payment_system.repository.PersonalAccountRepository;
import com.example.payment_system.service.PersonalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalAccountServiceImpl implements PersonalAccountService {
    @Autowired
    private PersonalAccountRepository accountRepository;

    @Override
    public PersonalAccount get(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public PersonalAccount add(PersonalAccount account) {
        return accountRepository.save(account);
    }

    @Override
    public PersonalAccount findByAccountNumber(String accountNum) {
        return accountRepository.findByAccountNumber(accountNum);
    }
}
