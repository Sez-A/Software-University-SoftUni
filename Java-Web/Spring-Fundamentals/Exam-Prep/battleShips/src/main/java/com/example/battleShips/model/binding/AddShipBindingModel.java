package com.example.battleShips.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddShipBindingModel {
    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private String category;

    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters.")
    public String getName() {
        return name;
    }

    public AddShipBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive(message = "The power must be positive.")
    public Long getPower() {
        return power;
    }

    public AddShipBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    @Positive(message = "The health must be positive.")
    public Long getHealth() {
        return health;
    }

    public AddShipBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    @PastOrPresent(message = "Created date cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public AddShipBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @NotBlank(message = "You must select the category.")
    public String getCategory() {
        return category;
    }

    public AddShipBindingModel setCategory(String category) {
        this.category = category;
        return this;
    }
}
