import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] numbersAsString = scan.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAsString.length ; i++) {
            int current = Integer.parseInt(numbersAsString[i]);
            numbers.add(current);
        }
int iterationCount = numbers.size() / 2;
        for (int i = 0; i < iterationCount ; i++) {
            int sum = 0;
            int lastIndex = numbers.size() - 1;
            sum =   numbers.get(i) + numbers.get(lastIndex);

            numbers.remove(lastIndex);
            numbers.set(i,sum);
        }
        for (Integer item: numbers) {
            System.out.print(item + " ");
        }
    }
}
