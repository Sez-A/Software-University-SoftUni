import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<Double, Integer>> buyList = new LinkedHashMap<>();
        String line = scan.nextLine();
        while (!line.equals("buy")) {
            String[] tokens = line.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            buyList.putIfAbsent(product, new LinkedHashMap<>());
            Map<Double, Integer> map = buyList.get(product);
            int oldValue = 0;
            if (map.isEmpty()) {
                map.put(price, quantity);
            } else {
                for (Integer value : map.values()) {
                    oldValue = value;
                }
                //buyList.remove(product);
                Map<Double, Integer> newPriceAndQuantity = new LinkedHashMap<>();
                newPriceAndQuantity.put(price, oldValue + quantity);
                buyList.put(product, newPriceAndQuantity);
            }


            line = scan.nextLine();
        }

        for (String product : buyList.keySet()) {
            Map<Double, Integer> priceAndQuantity = buyList.get(product);
            for (Map.Entry<Double, Integer> entry : priceAndQuantity.entrySet()) {
                System.out.printf("%s -> %.2f%n", product, entry.getKey() * entry.getValue());
            }

        }
    }
}
