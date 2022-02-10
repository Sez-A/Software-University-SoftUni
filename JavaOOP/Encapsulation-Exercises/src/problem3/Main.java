package problem3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] personInput = scan.nextLine().split(";");
        String[] productsInput = scan.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        for (String info : personInput) {
            String[] tokens = info.split("=");
            people.putIfAbsent(tokens[0], new Person(tokens[0], Double.parseDouble(tokens[1])));
        }

        for (String info : productsInput) {
            String[] tokens = info.split("=");
            products.putIfAbsent(tokens[0], new Product(tokens[0], Double.parseDouble(tokens[1])));
        }

        String line = "";
        while (!(line = scan.nextLine()).equals("END")) {
            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            if (people.containsKey(personName) && products.containsKey(productName)) {
                try {
                    people.get(personName).buyProduct(products.get(productName));
                    System.out.printf("%s bought %s%n", personName, productName);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        for (Person person : people.values()) {
            System.out.println(person);
        }
    }
}
