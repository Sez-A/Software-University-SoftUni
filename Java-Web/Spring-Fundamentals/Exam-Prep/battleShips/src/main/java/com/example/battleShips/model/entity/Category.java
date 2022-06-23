package com.example.battleShips.model.entity;

import com.example.battleShips.model.entity.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    private CategoryName name;
    private String description;

    @Enumerated
    @Column(nullable = false, unique = true)
    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
