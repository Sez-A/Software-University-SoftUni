import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        double price = 0;

        String inputText = scan.nextLine();
        while (!inputText.equals("Start")) {
            double coin = Double.parseDouble(inputText);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                sum += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            inputText = scan.nextLine();
        }
        String prducts = scan.nextLine();
        boolean availableProduct = false;
        while (!prducts.equals("End")) {
            switch (prducts) {
                case "Nuts":
                    price = 2.0;
                    availableProduct = true;
                    break;
                case "Water":
                    price = 0.7;
                    availableProduct = true;
                    break;
                case "Crisps":
                    price = 1.5;
                    availableProduct = true;
                    break;
                case "Soda":
                    price = 0.8;
                    availableProduct = true;
                    break;
                case "Coke":
                    price = 1.0;
                    availableProduct = true;
                    break;
            }if (sum < price) {
                System.out.println("Sorry, not enough money");

            }else if (availableProduct) {
                System.out.println(String.format("Purchased %s", prducts));
                sum -= price;
            } else {
                System.out.println("Invalid product");
            }
            prducts = scan.nextLine();
        }
        System.out.println(String.format("Change: %.2f",sum));
    }
}
