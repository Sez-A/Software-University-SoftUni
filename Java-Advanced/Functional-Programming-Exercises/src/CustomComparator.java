import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Comparator<Integer> comparator = (n1, n2) -> {
            if(n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }else if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }else {
                return n1.compareTo(n2) ;
            }
        };

        arr.stream()
                .sorted(comparator)
                .forEach(e -> System.out.print(e + " "));
    }
}
