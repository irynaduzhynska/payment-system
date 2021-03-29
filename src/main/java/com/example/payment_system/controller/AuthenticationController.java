package com.example.payment_system.controller;

import com.example.payment_system.dto.UserRegistrationDto;
import com.example.payment_system.entity.User;
import com.example.payment_system.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String showAddPersonPage() {
        return "register";
    }

    @PostMapping("/add")
    public String add(@Valid UserRegistrationDto user) {
        User register = service.register(user.getEmail(), user.getPassword());
        return "redirect:/login";
    }
}
