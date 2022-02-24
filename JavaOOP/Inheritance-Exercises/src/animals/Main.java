package animals;

import animals.Animal;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String type = scan.nextLine();
        while (!type.equals("Beast!")) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];
            try {

                animals.add(Animal.addNewAnimal(type, name, age, gender));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            type = scan.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
