import java.util.Scanner;

public class MultiplyEvenAndOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        number = Math.abs(number);

        evenSum(number);

        oddSum(number);

        multiplyEvenAndOddSum(number);
        System.out.println(multiplyEvenAndOddSum(number));

    }

    public static int evenSum(int numb) {
        int evenSum = 0;
        while (numb > 0) {
            int digit = numb % 10;
            numb = numb / 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
        }
        return evenSum;
    }

    public static int oddSum(int number) {
        int oddSum = 0;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }
        }
        return oddSum;
    }

    public static int multiplyEvenAndOddSum(int num) {
        return evenSum(num) * oddSum(num);
    }
}
