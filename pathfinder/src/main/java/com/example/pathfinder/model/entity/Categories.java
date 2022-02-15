package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Categories extends BaseEntity {
    private CategoryNamesEnum name;
    private String description;


    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    public CategoryNamesEnum getName() {
        return name;
    }

    public void setName(CategoryNamesEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
