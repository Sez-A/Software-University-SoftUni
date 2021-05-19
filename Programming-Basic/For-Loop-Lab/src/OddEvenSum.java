import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int evenSum = 0;
        int oddSum = 0;
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            if (i % 2 == 0)
                evenSum += num;
            else
                oddSum += num;
        }

        if (evenSum == oddSum) {
            System.out.println("Yes");
            System.out.println("Sum = " + evenSum);
        } else {
            System.out.println("No");
            System.out.println("Diff = " + Math.abs(evenSum - oddSum));
        }
    }
}
