package demoOOP;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Dog", 10);
        Cat cat = new Cat("Cat", 5);
        List<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.eat();
        }
    }
}
