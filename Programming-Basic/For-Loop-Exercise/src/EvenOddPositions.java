import java.util.Scanner;

public class EvenOddPositions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        double oddSum = 0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;

        double evenSum = 0;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            double num = Double.parseDouble(scan.nextLine());
            if (i % 2 == 0) {
                if (num > evenMax) {
                    evenMax = num;
                }
                if (num < evenMin) {
                    evenMin = num;
                }
                evenSum += num;
            } else {
                if (num > oddMax) {
                    oddMax = num;
                }
                if (num < oddMin) {
                    oddMin = num;
                }

                oddSum += num;
            }
        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        System.out.print("OddMin=");
        if (oddMin != Integer.MAX_VALUE)
            System.out.printf("%.2f,%n", oddMin);
        else
            System.out.println("No,");
        System.out.print("OddMax=");
        if (oddMax != Integer.MIN_VALUE)
            System.out.printf("%.2f,%n", oddMax);
        else
            System.out.println("No,");

        System.out.printf("EvenSum=%.2f,%n", evenSum);

        System.out.printf("EvenMin=");
        if (evenMin != Integer.MAX_VALUE)
            System.out.printf("%.2f,%n", evenMin);
        else
            System.out.println("No,");

        System.out.printf("EvenMax=");
        if (evenMax != Integer.MIN_VALUE)
            System.out.printf("%.2f%n", evenMax);
        else System.out.println("No");
    }
}
