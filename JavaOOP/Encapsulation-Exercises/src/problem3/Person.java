package problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // TODO: 24.5.2021 г. Maybe we will have problem with name like Pesho Peshev
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.money = this.money - product.getCost();
            this.products.add(product);
        } else {
            throw new IllegalStateException(String.format("%s can't afford %s"
                    , this.getName(), product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName() + " - ");
        if (this.products.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            sb.append(this.products
                    .stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", ")));
        }
        return sb.toString();
    }

    // Todo Solution in main
    //        String[] personInput = scan.nextLine().split(";");
    //        String[] productsInput = scan.nextLine().split(";");
    //
    //        Map<String, Person> people = new LinkedHashMap<>();
    //        Map<String, Product> products = new LinkedHashMap<>();
    //
    //        for (String info : personInput) {
    //            String[] tokens = info.split("=");
    //            people.putIfAbsent(tokens[0], new Person(tokens[0], Double.parseDouble(tokens[1])));
    //        }
    //
    //        for (String info : productsInput) {
    //            String[] tokens = info.split("=");
    //            products.putIfAbsent(tokens[0], new Product(tokens[0], Double.parseDouble(tokens[1])));
    //        }
    //
    //        String line = "";
    //        while (!(line = scan.nextLine()).equals("END")) {
    //            String[] tokens = line.split("\\s+");
    //            String personName = tokens[0];
    //            String productName = tokens[1];
    //            if (people.containsKey(personName) && products.containsKey(productName)) {
    //                try {
    //                    people.get(personName).buyProduct(products.get(productName));
    //                    System.out.printf("%s bought %s%n", personName, productName);
    //                } catch (Exception e) {
    //                    System.out.println(e.getMessage());
    //                }
    //            }
    //        }
    //
    //        for (Person person : people.values()) {
    //            System.out.println(person);
    //        }
}
