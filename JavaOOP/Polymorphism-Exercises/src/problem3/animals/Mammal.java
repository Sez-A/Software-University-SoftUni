package problem3.animals;

import problem3.foods.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType,
                     Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        switch (super.getClass().getSimpleName()) {
            case "Cat":
                System.out.println("Meowwww");
                break;
            case "Tiger":
                System.out.println("ROAAR!!!");
                break;
            case "Zebra":
                System.out.println("Zs");
                break;
            case "Mouse":
                System.out.println("SQUEEEAAAK!");
                break;
        }
    }

    @Override
    public void eat(Food food) {
        switch (this.getClass().getSimpleName()) {
            case "Cat":
                super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
                break;
            case "Tiger":
                super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
                break;
            case "Zebra":
                super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
                break;
            case "Mouse":
                super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
                break;
        }
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        return String.format("%s[%s, %s, %s, %d]"
                , super.getClass().getSimpleName(),
                super.getAnimalName(),
                decimalFormat.format(
                        super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }
}
