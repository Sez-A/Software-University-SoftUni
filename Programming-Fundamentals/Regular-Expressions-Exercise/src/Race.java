import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> racersInput = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> map = new LinkedHashMap<>();

        String letterRegex = "[A-Z]{1}|[a-z]";
        Pattern letterPattern = Pattern.compile(letterRegex);
        Pattern digitPattern = Pattern.compile("[0-9]{1}");
        String line;

        while (!(line = scan.nextLine()).equals("end of race")) {
            Matcher letterMatcher = letterPattern.matcher(line);
            Matcher digitMatcher = digitPattern.matcher(line);
            String name = "";
            int distance = 0;
            while (letterMatcher.find()) {
                name += letterMatcher.group();
            }

            while (digitMatcher.find()) {
                distance += Integer.parseInt(digitMatcher.group());
            }

            if (racersInput.contains(name)) {
                map.putIfAbsent(name, 0);
                map.put(name, map.get(name) + distance);
            }
        }

        AtomicInteger integer = new AtomicInteger(1);
        map
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .forEach(e -> {
                    if (integer.get() == 1) {
                        System.out.printf("1st place: %s%n", e.getKey());
                        integer.getAndIncrement();
                    }else if (integer.get() == 2) {
                        System.out.printf("2nd place: %s%n", e.getKey());
                        integer.getAndIncrement();
                    }else {
                        System.out.printf("3rd place: %s%n", e.getKey());
                    }
                });
    }
}
