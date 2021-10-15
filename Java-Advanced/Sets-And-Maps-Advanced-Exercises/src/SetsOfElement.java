import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n =input[0];
        int m =input[1];
        Set<Integer> firstSet = new LinkedHashSet<>();
        for (int i = 0; i <n  ; i++) {
            int number = Integer.parseInt(scan.nextLine());
            firstSet.add(number);
        }

        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < m ; i++) {
            int number = Integer.parseInt(scan.nextLine());
            secondSet.add(number);
        }
       firstSet.retainAll(secondSet);
        for (Integer integer : firstSet) {
            System.out.print(integer + " ");
        }
    }
}
