import java.text.DecimalFormat;
import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        String town = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());
        double productPrice = 0;

        if (town.equals("Sofia")) {
            switch (product) {
                case "coffee":
                    productPrice = quantity * 0.5;
                    break;
                case "water":
                    productPrice = quantity * 0.8;
                    break;
                case "beer":
                    productPrice = quantity * 1.2;
                    break;
                case "sweets":
                    productPrice = quantity * 1.45;
                    break;
                case "peanuts":
                    productPrice = quantity * 1.60;
                    break;
            }

        } else if (town.equals("Plovdiv")) {
            switch (product) {
                case "coffee":
                    productPrice = quantity * 0.4;
                    break;
                case "water":
                    productPrice = quantity * 0.7;
                    break;
                case "beer":
                    productPrice = quantity * 1.15;
                    break;
                case "sweets":
                    productPrice = quantity * 1.30;
                    break;
                case "peanuts":
                    productPrice = quantity * 1.50;
                    break;
            }
        } else if (town.equals("Varna")) {
            switch (product) {
                case "coffee":
                    productPrice = quantity * 0.45;
                    break;
                case "water":
                    productPrice = quantity * 0.7;
                    break;
                case "beer":
                    productPrice = quantity * 1.10;
                    break;
                case "sweets":
                    productPrice = quantity * 1.35;
                    break;
                case "peanuts":
                    productPrice = quantity * 1.55;
                    break;
            }
        }
        DecimalFormat dec = new DecimalFormat("#.####");

        System.out.printf("%s", dec.format(productPrice));
    }
}
