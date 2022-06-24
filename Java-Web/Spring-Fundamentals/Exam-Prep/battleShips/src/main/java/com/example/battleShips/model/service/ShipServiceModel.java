package com.example.battleShips.model.service;

import java.time.LocalDate;

public class ShipServiceModel {
    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private String category;

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipServiceModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(String category) {
        this.category = category;
        return this;
    }
}
