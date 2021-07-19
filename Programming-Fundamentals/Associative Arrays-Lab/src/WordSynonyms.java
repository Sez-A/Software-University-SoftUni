
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, ArrayList<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }

        for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
            String output = String.format("%s - %s",entry.getKey(),String.join(", ",entry.getValue()));
            System.out.println(output);
//            System.out.println("-----------------------");
//            System.out.printf("%s - %s%n",entry.getKey(),String.join(", ",entry.getValue()));
        }
    }
}
