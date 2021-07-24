import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CntCharInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.nextLine().toCharArray();
        Map<Character, Integer> letters = new LinkedHashMap<>();
        for (char letter : input) {
            if (letter == ' ') {
                continue;
            }
            letters.putIfAbsent(letter, 0);
            int oldCount = letters.get(letter);
            letters.put(letter, oldCount + 1);
        }
        // Both options work!
        letters
                .entrySet()
                /* -> */.forEach(e -> System.out.println(String.format("%c -> %d", e.getKey(), e.getValue())));
        // -> // .forEach((k,v) -> System.out.println(String.format("%c -> %d",k,v)));
    }
}
