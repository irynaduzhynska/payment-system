package com.example.payment_system.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "personal_accounts")
@Data
@NoArgsConstructor
public class PersonalAccount {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "personal_account_id")
    private User user;
    private String accountNumber;
    private long units;

    public PersonalAccount(User user, String accountNumber, long units) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.units = units;
    }
}
