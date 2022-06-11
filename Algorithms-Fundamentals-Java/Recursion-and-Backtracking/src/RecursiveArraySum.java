import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        long sum = sumArray(arr, 0);
        System.out.println(sum);
    }

    private static long sumArray(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        return arr[index] + sumArray(arr, index + 1);
    }
}
