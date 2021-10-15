import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            map.putIfAbsent(symbol, 0);
            int oldCount = map.get(symbol);
            map.put(symbol,oldCount + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%c: %d time/s",entry.getKey(),entry.getValue()));
        }
    }
}
