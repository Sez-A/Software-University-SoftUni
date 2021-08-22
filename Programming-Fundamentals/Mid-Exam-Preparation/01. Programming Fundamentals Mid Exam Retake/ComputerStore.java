package midexam01retake;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        boolean specialCustomer = false;
        double priceWithoutTaxes = 0.0;
        double taxes = 0.0;
        double totalPrice = 0.0;

        while (!line.equals("regular")) {

            if (line.equals("special")) {
                specialCustomer = true;
                break;
            }

            double currentPrice = Double.parseDouble(line);
            if (currentPrice < 0) {
                System.out.println("Invalid price!");

            } else {
                priceWithoutTaxes += currentPrice;
                taxes += currentPrice * 0.2;
            }

            line = scan.nextLine();

        }

        totalPrice += priceWithoutTaxes + taxes;

        if (totalPrice <= 0) {
            System.out.println("Invalid order!");
            return;
        }

        if (specialCustomer) {
            double discount = totalPrice * 0.1;
            totalPrice -= discount;
        }
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
        System.out.printf("Taxes: %.2f$%n", taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$%n", totalPrice);


    }
}
