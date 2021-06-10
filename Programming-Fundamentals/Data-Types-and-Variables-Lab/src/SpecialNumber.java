import java.util.Scanner;

public class SpecialNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        //int sum = 0;
        for (int i = 1; i <= n; i++) {
            int currentNumber = i;
            int sum = 0;
            while (currentNumber > 0) {
                int digit = currentNumber % 10;
                sum += digit;
                currentNumber = currentNumber / 10;
            }

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.println(String.format("%d -> False", i));
            }
        }
    }
}
