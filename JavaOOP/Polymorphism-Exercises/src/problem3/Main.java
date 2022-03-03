package problem3;

import animals.Animal;
import animals.feline.Cat;
import animals.feline.Tiger;
import animals.mice.Mouse;
import animals.zebras.Zebra;
import foods.Food;
import foods.Meat;
import foods.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!line.equals("End")) {
            String[] animalInfo = line.split("\\s+");
            String[] foodInfo = scan.nextLine().split("\\s+");

            switch (animalInfo[0]) {
                case "Cat":
                    Cat cat = new Cat(animalInfo[1], animalInfo[0]
                            ,Double.parseDouble(animalInfo[2]),animalInfo[3],animalInfo[4]);
                    cat.makeSound();
                    if(foodInfo[0].equals("Vegetable"))
                        cat.eat(new Vegetable(Integer.parseInt(foodInfo[1])));
                    else
                        cat.eat(new Meat(Integer.parseInt(foodInfo[1])));

                    animals.add(cat);

                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(animalInfo[1], animalInfo[0]
                            ,Double.parseDouble(animalInfo[2]),animalInfo[3]);
                    tiger.makeSound();
                    if(foodInfo[0].equals("Meat")) {
                        tiger.eat(new Meat(Integer.parseInt(foodInfo[1])));
                    }else {
                        System.out.println("Tigers are not eating that type of food!");
                    }

                    animals.add(tiger);

                    break;

                case "Mouse":
                    Mouse mouse = new Mouse(animalInfo[1], animalInfo[0]
                            ,Double.parseDouble(animalInfo[2]),animalInfo[3]);
                    mouse.makeSound();
                    if(foodInfo[0].equals("Vegetable"))
                        mouse.eat(new Vegetable(Integer.parseInt(foodInfo[1])));
                    else
                        System.out.println("Mice are not eating that type of food!");

                    animals.add(mouse);

                    break;

                case "Zebra":
                    Zebra zebra = new Zebra(animalInfo[1], animalInfo[0]
                            ,Double.parseDouble(animalInfo[2]),animalInfo[3]);
                    zebra.makeSound();
                    if(foodInfo[0].equals("Vegetable"))
                        zebra.eat(new Vegetable(Integer.parseInt(foodInfo[1])));
                    else
                        System.out.println("Zebras are not eating that type of food!");

                    animals.add(zebra);

                    break;
            }
            line = scan.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
