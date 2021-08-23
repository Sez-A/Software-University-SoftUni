package midexam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int averageValue = 0;

        for (Integer number : numbers) {
            averageValue += number;
        }

        averageValue /= numbers.size();

        numbers = numbers.stream()
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        List<Integer> topInts = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > averageValue && topInts.size() < 5) {
                topInts.add(numbers.get(i));
            }
        }

        topInts = topInts.stream()
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        if (topInts.isEmpty()) {
            System.out.println("No");
        } else {
            for (Integer num : topInts) {
                System.out.print(num + " ");
            }
        }
    }
}
