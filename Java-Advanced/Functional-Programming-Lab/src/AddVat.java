import java.util.Arrays;
import java.util.Scanner;

public class AddVat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] prices = Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .map(e -> e * 1.2)
                .toArray();

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .forEach(e -> System.out.println(String.format("%.2f",e)));
    }
}
