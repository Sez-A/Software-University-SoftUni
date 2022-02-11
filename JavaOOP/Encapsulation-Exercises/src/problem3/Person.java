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
}
