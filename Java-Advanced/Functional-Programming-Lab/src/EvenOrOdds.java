import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EvenOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] bound = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        String format = scan.nextLine();

        Map<String, Predicate<Integer>> predicateMap = new HashMap<>();

        predicateMap.put("even", e -> e % 2 == 0);
        predicateMap.put("odd", e -> e % 2 != 0);

        int range = bound[1] - bound[0] + 1;
        Integer[] newArr = new Integer[range];
        int newIndex = 0;
        for (int i = bound[0]; i <= bound[1]; i++) {
            newArr[newIndex++] = i;
        }


        Arrays.stream(newArr)
                .filter(predicateMap.get(format))
                .forEach( e -> System.out.print(e + " "));
    }
}
