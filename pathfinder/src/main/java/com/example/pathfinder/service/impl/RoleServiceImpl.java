package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.enums.RoleNamesEnum;
import com.example.pathfinder.repository.RoleRepository;
import com.example.pathfinder.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

    }

    @Override
    public Role getRoleByName(String roleName) {

        return this.roleRepository.findByRole(RoleNamesEnum.valueOf(roleName.toUpperCase()));
    }
}
