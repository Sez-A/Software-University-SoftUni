package problem4;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private int numberOfToppings;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Dough getDough() {
        return dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        return this.getDough().calculateCalories() +
                this.getToppings().stream().
                        mapToDouble(Topping::calculateCalories)
                        .sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f%n", this.getName(), this.getOverallCalories());
    }
}
