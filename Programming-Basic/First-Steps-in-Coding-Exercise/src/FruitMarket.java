import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double strawberryPrice = Double.parseDouble(scan.nextLine());

        double bananaQuantity = Double.parseDouble(scan.nextLine());

        double orangeQuantity = Double.parseDouble(scan.nextLine());

        double raspberriesQuantity = Double.parseDouble(scan.nextLine());

        double strawberryQuantity = Double.parseDouble(scan.nextLine());

        double raspberriesPrice = strawberryPrice * 0.5;
        double orangesPrice = raspberriesPrice - (0.4 * raspberriesPrice);
        double bananasPrice = raspberriesPrice - (0.8 * raspberriesPrice);

        double raspberriesCost = raspberriesQuantity * raspberriesPrice;
        double orangesCost = orangeQuantity * orangesPrice;
        double bananasCost = bananaQuantity * bananasPrice;
        double strawberryCost = strawberryQuantity * strawberryPrice;

        double neededMoney = raspberriesCost + orangesCost + bananasCost + strawberryCost;

        System.out.printf("%.2f%n",neededMoney);

    }
}
