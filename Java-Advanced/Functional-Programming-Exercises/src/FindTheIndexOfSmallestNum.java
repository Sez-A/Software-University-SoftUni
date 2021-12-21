import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheIndexOfSmallestNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> function = a -> {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= min) {
                    min = a[i];
                    index = i;
                }
            }
            return index;
        };

        Integer index = function.apply(numbers);
        System.out.println(index);

    }
}
