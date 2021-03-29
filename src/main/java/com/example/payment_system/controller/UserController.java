package com.example.payment_system.controller;

import com.example.payment_system.dto.AccountDto;
import com.example.payment_system.entity.PersonalAccount;
import com.example.payment_system.entity.User;
import com.example.payment_system.mapper.UserMapper;
import com.example.payment_system.service.PersonalAccountService;
import com.example.payment_system.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final UserService userService;
    private final PersonalAccountService accountService;
    private final UserMapper mapper;

    public UserController(UserService userService,
                          PersonalAccountService accountService,
                          UserMapper mapper) {
        this.userService = userService;
        this.accountService = accountService;
        this.mapper = mapper;
    }

    @GetMapping("/user")
    public String getUsers(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<User> all = userService.getAll();
        model.addAttribute("users", all.stream()
                .filter(user -> !user.getEmail().equals(userDetails.getUsername()))
                .map(mapper::fromEntityToDtoForUserPage).collect(Collectors.toList()));
        return "allUsers";
    }

    @PostMapping("/sendUnit")
    public String sendUnit(@Valid AccountDto accountDto,
                           Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User fromUser = userService.findByEmail(userDetails.getUsername());
        PersonalAccount fromAccount = accountService.get(fromUser.getId());
        fromAccount.setUnits(fromAccount.getUnits() - accountDto.getUnits());

        PersonalAccount toAccount = accountService
                .findByAccountNumber(accountDto.getAccountNumber());
        toAccount.setUnits(toAccount.getUnits() + accountDto.getUnits());
        accountService.add(fromAccount);
        accountService.add(toAccount);
        return "redirect:/userPage";
    }

    @GetMapping("/userPage")
    public String homePage(Authentication authentication, Model mode) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        PersonalAccount personalAccount = accountService.get(user.getId());
        mode.addAttribute("response", List.of(mapper.fromEntitiesToDto(personalAccount, user)));
        return "homePage";
    }
}
