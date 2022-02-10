package problem4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {


            String[] pizzaInfo = scan.nextLine().split("\\s+");
            Pizza pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));
            String[] doughInfo = scan.nextLine().split("\\s+");
            Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));

            pizza.setDough(dough);
            String command = "";

            while (!(command = scan.nextLine()).equals("END")) {
                String[] toppingInfo = command.split("\\s+");

                Topping topping = new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));
                pizza.addTopping(topping);
            }

            System.out.println(String.format("%s - %.2f", pizzaInfo[1], pizza.getOverallCalories()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
