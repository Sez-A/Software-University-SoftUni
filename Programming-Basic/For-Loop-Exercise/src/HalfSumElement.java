import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int maxElement = Integer.MIN_VALUE;
        int previousMax = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            if (num > maxElement) {
                sum += previousMax;
                maxElement = num;
                previousMax = maxElement;
            } else {
                sum += num;
            }
        }
        if (sum == maxElement) {
            System.out.println("Yes");
            System.out.println("Sum = " + sum);
        } else {
            System.out.printf("No%nDiff = %d%n", Math.abs(maxElement - sum));
        }
    }
}
