import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= n; i++) {
            if (isTopInteger(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isTopInteger(int number) {
        int sumOfDigits = 0;
        int oddCounter = 0;
        while (number > 0) {
            int digit = number % 10;
            sumOfDigits += digit;
            number = number / 10;
            if (digit % 2 != 0) {
                oddCounter++;
            }
        }
        if (sumOfDigits % 8 == 0 && oddCounter >= 1) {
            return true;
        }
        return false;
    }
}
