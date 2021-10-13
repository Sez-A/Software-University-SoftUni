import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main
            (String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            map.putIfAbsent(number,0);
            Integer currentCount = map.get(number);
            map.put(number,currentCount + 1);
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%.1f -> %d",entry.getKey(),entry.getValue()));
        }
    }
}
