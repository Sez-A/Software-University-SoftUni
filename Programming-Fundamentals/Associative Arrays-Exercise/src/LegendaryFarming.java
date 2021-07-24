import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> items = new TreeMap<>() {{
            put("shards", 0);
            put("fragments", 0);
            put("motes", 0);
        }};

        Map<String, Integer> others = new TreeMap<>();

        boolean isObtained = false;
        while (!isObtained) {
            String[] tokens = scan.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int count = Integer.parseInt(tokens[i]);
                String type = tokens[i + 1].toLowerCase();
                if (items.containsKey(type)) {
                    addItem(items, type, count);
                    isObtained = findItem(items, type);
                    if(isObtained){
                        break;
                    }
                } else {
                    addItem(others, type, count);
                }
            }
        }
        items
                .entrySet()
                .stream()
                .sorted((i1,i2)-> i2.getValue().compareTo(i1.getValue()))
                .forEach(i -> System.out.println(String.format("%s: %d",i.getKey(),i.getValue())));
        others
                .forEach((k,v) -> System.out.println(String.format("%s: %d",k,v)));
    }

    public static void addItem(Map<String, Integer> map, String key, int value) {
        map.putIfAbsent(key, 0);
        int oldCount = map.get(key);
        map.put(key, oldCount + value);
    }

    public static boolean findItem(Map<String, Integer> item, String type) {
        int count = item.get(type);
        if (count >= 250) {
            item.put(type, count - 250);
            switch (type) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    return true;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    return true;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    return true;
            }
        }
        return false;
    }
}
