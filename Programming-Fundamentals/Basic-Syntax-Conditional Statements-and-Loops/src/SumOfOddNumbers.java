import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        int counter = -1;
        while (n-- > 0) {
            System.out.println(counter += 2);
            sum += counter;
        }
        System.out.println("Sum: " + sum);
    }
}
