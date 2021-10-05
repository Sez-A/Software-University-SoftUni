import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> numbersForPrint = new ArrayDeque<>();

        for (int number : numbers) {
            numbersForPrint.push(number);
        }

        for (Integer num : numbersForPrint) {
            System.out.print(num + " ");
        }
    }
}
