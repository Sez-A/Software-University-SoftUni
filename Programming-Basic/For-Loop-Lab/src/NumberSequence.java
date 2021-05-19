import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            if (num > maxNumber) {
                maxNumber = num;
            }
            if (num < minNumber) {
                minNumber = num;
            }
        }
        System.out.printf("Max number: %d%nMin number: %d%n", maxNumber, minNumber);
    }
}
