package com.example.payment_system.mapper;

import com.example.payment_system.dto.UserResponseDto;
import com.example.payment_system.dto.UserResponseForUserPageDto;
import com.example.payment_system.entity.PersonalAccount;
import com.example.payment_system.entity.User;
import com.example.payment_system.service.PersonalAccountService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final PersonalAccountService accountService;

    public UserMapper(PersonalAccountService accountService) {
        this.accountService = accountService;
    }

    public UserResponseDto fromEntitiesToDto(PersonalAccount account, User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setPassword(user.getPassword());
        responseDto.setUnits(account.getUnits());
        responseDto.setAccountNumber(account.getAccountNumber());
        return responseDto;
    }

    public UserResponseForUserPageDto fromEntityToDtoForUserPage(User user) {
        PersonalAccount account = accountService.get(user.getId());
        UserResponseForUserPageDto response = new UserResponseForUserPageDto();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setAccountNumber(account.getAccountNumber());
        return response;
    }
}
