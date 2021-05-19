import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i < n ; i++) {
            int num = Integer.parseInt(scan.nextLine());
            rightSum += num;
        }
        for (int i = 0; i < n ; i++) {
            int num = Integer.parseInt(scan.nextLine());
            leftSum += num;
        }

        if (rightSum == leftSum) {
            System.out.println("Yes, sum = " + rightSum);
        } else {
            System.out.println("No, diff = " + Math.abs(rightSum - leftSum));
        }
    }
}
