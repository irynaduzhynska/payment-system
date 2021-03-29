package com.example.payment_system.repository;

import com.example.payment_system.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role getByRoleName(String name);
}
