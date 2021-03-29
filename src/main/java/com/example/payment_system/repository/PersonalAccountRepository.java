package com.example.payment_system.repository;

import com.example.payment_system.entity.PersonalAccount;
import org.springframework.data.repository.CrudRepository;

public interface PersonalAccountRepository extends CrudRepository<PersonalAccount, Long> {
    PersonalAccount findByAccountNumber(String accountNumber);
}
