import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int target = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> predicate = e -> e.length() <= target;

        Arrays.stream(names)
                .filter(predicate)
                .forEach(System.out::println);

    }
}
