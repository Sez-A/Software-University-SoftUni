import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputNumbers = scan.nextLine().split(" ");
        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < inputNumbers.length; i++) {
            double num = Double.parseDouble(inputNumbers[i]);
            numbers.add(num);
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                double sumOfDigits = numbers.get(i) * 2;
                numbers.remove(i);
                numbers.set(i, sumOfDigits);
                i = -1;
            }
        }
        for (Double item: numbers) {
            System.out.print(new DecimalFormat("0.#").format(item) + " ");
        }
    }
}
