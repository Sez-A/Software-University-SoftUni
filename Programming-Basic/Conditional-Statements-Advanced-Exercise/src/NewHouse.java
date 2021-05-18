import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String flowerType = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());
        double finalPrice = 0;
        switch (flowerType) {
            case "Roses":
                finalPrice = quantity * 5;
                if (quantity > 80) {
                    finalPrice = finalPrice - (finalPrice * 0.1);
                }
                break;

            case "Dahlias":
                finalPrice = quantity * 3.8;
                if (quantity > 90) {
                    finalPrice = finalPrice - (finalPrice * 0.15);
                }
                break;

            case "Tulips":
                finalPrice = quantity * 2.8;
                if (quantity > 80) {
                    finalPrice = finalPrice - (finalPrice * 0.15);
                }
                break;

            case "Narcissus":
                finalPrice = quantity * 3;
                if (quantity < 120) {
                    finalPrice += finalPrice * 0.15;
                }
                break;

            case "Gladiolus":
                finalPrice = quantity * 2.5;
                if (quantity < 80) {
                    finalPrice += finalPrice * 0.2;
                }
                break;
        }
        if (finalPrice > budget) {
            System.out.printf("Not enough money, you need %.2f leva more.%n", finalPrice - budget);
        } else {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                    quantity, flowerType, budget - finalPrice);
            ;
        }
    }
}
