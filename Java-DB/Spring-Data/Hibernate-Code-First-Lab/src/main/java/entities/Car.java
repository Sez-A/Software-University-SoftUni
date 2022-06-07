package entities;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
    public Car() {
        super("CAR");
    }
}
