import java.util.*;

public class RealNumbersCount {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(n->Double.parseDouble(n))
                .toArray();
        Map<Double, Integer> count = new TreeMap<>();
       for (double number:numbers){
           if (!count.containsKey(number)) {
               count.put(number, 1);
           } else {
               count.put(number, count.get(number) + 1);
           }
       }

        for (Map.Entry<Double, Integer> entry : count.entrySet()) {
            System.out.println(String.format("%.0f -> %d",entry.getKey(),entry.getValue()));
        }
    }
}
