package com.example.pathfinder.util;

import com.example.pathfinder.model.entity.enums.RoleNamesEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String username;
    private Set<RoleNamesEnum> roles;

    public CurrentUser() {
        this.roles = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<RoleNamesEnum> getRoles() {
        return roles;
    }

    public CurrentUser setRoles(Set<RoleNamesEnum> roles) {
        this.roles = roles;
        return this;
    }

    public boolean isAdmin() {
        return this.roles.contains(RoleNamesEnum.ADMIN);
    }

    public void addRole(RoleNamesEnum role) {
        this.roles.add(role);
    }

    public void clear() {
        this.setUsername(null)
                .setId(null);
        this.roles.clear();
    }
}
