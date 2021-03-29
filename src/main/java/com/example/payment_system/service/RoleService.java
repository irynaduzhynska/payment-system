package com.example.payment_system.service;

import com.example.payment_system.entity.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
