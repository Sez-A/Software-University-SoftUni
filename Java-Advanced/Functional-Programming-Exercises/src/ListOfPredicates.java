import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        BiPredicate<int[], Integer> predicate = (arr,num) -> {
            for (int i : arr) {
                if(num % i != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n ; i++) {
            if( predicate.test(numbers,i)) {
                System.out.print( i + " ");
            }
        }

    }
}
