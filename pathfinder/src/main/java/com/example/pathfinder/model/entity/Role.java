package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleNamesEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    private RoleNamesEnum role;

    @Enumerated(EnumType.STRING)
    public RoleNamesEnum getRole() {
        return role;
    }

    public void setRole(RoleNamesEnum role) {
        this.role = role;
    }
}
