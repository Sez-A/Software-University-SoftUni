import java.util.Scanner;

public class RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int currentNumber = 1;
        int sum = 0;
        for (int i = n; i > 0; i--) {
            System.out.println(currentNumber);
            sum += currentNumber;
            currentNumber += 2;
        }
        System.out.printf("Sum: %d%n", sum);
    }
}
