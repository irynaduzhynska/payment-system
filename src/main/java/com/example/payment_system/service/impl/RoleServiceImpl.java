package com.example.payment_system.service.impl;

import com.example.payment_system.entity.Role;
import com.example.payment_system.repository.RoleRepository;
import com.example.payment_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getByRoleName(roleName);
    }
}
