import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> chest = new LinkedHashMap<>();
        String item = scan.nextLine();
        while (!item.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            if (chest.containsKey(item)) {
                Integer oldQuantity = chest.get(item);
                chest.put(item, oldQuantity + quantity);
            } else {
                chest.put(item, quantity);
            }

            item = scan.nextLine();
        }

        chest
                .forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
