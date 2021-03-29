package com.example.payment_system.service;

import com.example.payment_system.entity.User;

public interface AuthenticationService {
    User register(String email, String password);
}
