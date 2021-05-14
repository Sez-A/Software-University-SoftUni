import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double yardSize = Double.parseDouble(scan.nextLine());
        double priceBeforeDiscount = yardSize * 7.61;
        double discount = priceBeforeDiscount * 0.18;
        double finalPrice = priceBeforeDiscount - discount;

        System.out.printf("The final price is: %.2f lv.%n",finalPrice);
        System.out.printf("The discount is: %.2f lv.%n", discount);
    }
}
