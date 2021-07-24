import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Double> products = new LinkedHashMap<>();
        Map<String,Integer> rememberProducts = new LinkedHashMap<>();
        while (!"buy".equals(input)) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);
            if(!products.containsKey(type)){
                products.put(type,quantity * price);
                rememberProducts.put(type,quantity);
            }else{
               rememberProducts.put(type,rememberProducts.get(type) + quantity);
               products.put(type,rememberProducts.get(type) * price);
            }
            input = scan.nextLine();
        }
        products
                .forEach((k,v) -> System.out.println(String.format("%s -> %.2f",k,v)));
    }
}
