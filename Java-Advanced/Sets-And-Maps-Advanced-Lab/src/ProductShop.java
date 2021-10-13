import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);

            if (!shops.containsKey(shop)) {
                shops.put(shop, new LinkedHashMap<>());
                Map<String, Double> productsAndPrices = shops.get(shop);
                productsAndPrices.put(product, price);
            } else {
                Map<String, Double> productsAndPrices = shops.get(shop);
                productsAndPrices.put(product, price);
            }
        }

        shops
                .forEach((key, productsAndPrices) -> {
                    System.out.println(key + "->");
                    productsAndPrices.
                            forEach((k, v) -> System.out.printf("Product: %s, Price: %.1f%n", k, v));
                });
    }
}
