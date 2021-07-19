import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // My solution
        String[] input = scan.nextLine().split("\\s+");
        List<String> words = new ArrayList<>();
        for (String word : input) {
            words.add(word);
        }
        words.stream()
                .filter(w -> w.length() % 2 == 0)
                .forEach(w -> System.out.println(w));

        // SoftUni solution
        //        String[] words = Arrays.stream(scan.nextLine().split(" "))
        //                .filter(w -> w.length() % 2 == 0)
        //                .toArray(String[]::new);
        //
        //        Arrays.stream(words)
        //                .forEach(w -> System.out.println(w));
    }
}
