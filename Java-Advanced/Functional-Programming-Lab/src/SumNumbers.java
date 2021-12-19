import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> count = a -> "Count = " + a.length;



        Function<int[],String> sum =  a -> "Sum = " + Arrays.stream(a).sum();

        System.out.println(count.apply(arr));
        System.out.println(sum.apply(arr));
    }
}

