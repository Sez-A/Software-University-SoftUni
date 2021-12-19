import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers =
                Arrays.stream(scan.nextLine().split(", "))
                        .mapToInt(Integer::parseInt)
                        .filter(n -> n % 2 == 0)
//                        .forEach(System.out::println)
                        .toArray();

        System.out.println(Arrays.stream(numbers)
                .mapToObj(e -> String.valueOf(e))
                .collect(Collectors.joining(", ")));

        System.out.println(Arrays.stream(numbers)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
