package com.example.payment_system.service;

import com.example.payment_system.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);

    List<User> getAll();

    User findByEmail(String email);
}
