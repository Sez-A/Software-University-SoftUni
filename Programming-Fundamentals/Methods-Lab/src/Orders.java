import java.util.Scanner;

public class Orders {

    public static double totalPrice(String name, double count) {
        double price = 0.000;
        if (name.equals("coffee")) {
            price = count * 1.50;
        } else if (name.equals("water")) {
            price = count * 1.00;
        } else if (name.equals("coke")) {
            price = count * 1.40;
        } else if (name.equals("snacks")) {
            price = count * 2.00;
        }
        return price;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());
        double totalPrice = totalPrice(product, quantity);
        System.out.println(String.format("%.2f", totalPrice));
    }
}
