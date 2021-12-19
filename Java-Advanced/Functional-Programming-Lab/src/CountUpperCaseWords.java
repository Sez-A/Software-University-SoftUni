import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputArr = scan.nextLine().split("\\s+");

        List<String> list = new LinkedList<>();
        int cnt = 0;
        for (String s : inputArr) {
            if (Character.isUpperCase(s.charAt(0))) {
                cnt++;
                list.add(s);
            }
        }


        Predicate<String> predicate = s -> Character.isUpperCase(s.charAt(0));

        AtomicInteger i = new AtomicInteger(0);

        StringBuilder sb = new StringBuilder();

        Consumer<String> consumer = e -> {
            i.getAndIncrement();
            sb.append(e).append(System.lineSeparator());
        };


        Arrays.stream(inputArr)
                .filter(predicate)
                .forEach(consumer);

        System.out.println(i);
        System.out.println(sb.toString());
    }
}
