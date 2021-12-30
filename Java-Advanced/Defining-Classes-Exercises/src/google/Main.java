package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Person> personMap = new HashMap<>();

        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];

            if (!personMap.containsKey(name)) {
                Person person = new Person(name);
                fillData(tokens, person);
                personMap.put(name, person);
            } else {
                Person current = personMap.get(name);
                fillData(tokens, current);
            }

        }

        Person person = personMap.get(scan.nextLine());
        System.out.println(person);
    }

    private static void fillData(String[] tokens, Person person) {
        switch (tokens[1]) {
            case "company":
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                person.setCompany(new Company(companyName, department, salary));
                break;
            case "pokemon":
                person.addPokemon(new Pokemon(tokens[2], tokens[3]));
                break;
            case "parents":
                person.getParents().add(new Parent(tokens[2], tokens[3]));
                break;
            case "children":
                person.getChildren().add(new Children(tokens[2], tokens[3]));
                break;
            case "car":
                person.setCar(new Car(tokens[2], Integer.parseInt(tokens[3])));
                break;
        }
    }
}
