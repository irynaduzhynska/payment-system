package com.example.payment_system.service.impl;

import com.example.payment_system.entity.PersonalAccount;
import com.example.payment_system.entity.Role;
import com.example.payment_system.entity.User;
import com.example.payment_system.repository.RoleRepository;
import com.example.payment_system.service.AuthenticationService;
import com.example.payment_system.service.PersonalAccountService;
import com.example.payment_system.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PersonalAccountService accountService;
    private final RoleRepository roleRepository;

    public AuthenticationServiceImpl(UserService userService,
                                     PersonalAccountService accountService,
                                     RoleRepository roleRepository) {
        this.userService = userService;
        this.accountService = accountService;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public User register(String email, String password) {
        User user = new User(email, password);
        Role roleName;
        roleName = roleRepository.getByRoleName("USER");
        user.setRoles(Set.of(roleName));
        userService.add(user);
        accountService.add(new PersonalAccount(user, getRandomAccountNumber(), 1000L));
        return user;
    }

    private String getRandomAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append((int) (Math.random() * 8999) + 1000);
        }
        return sb.toString();
    }
}
