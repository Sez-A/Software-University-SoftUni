import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int target = Integer.parseInt(scan.nextLine());
        int cnt = 0;
        boolean flag = false;
        String combination = "";
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                cnt++;
                if (i + j == target) {
                    combination = String.format("(%d + %d = %d)", i, j, target);
                    flag = true;
                    break;
                }

            }
            if (flag)
                break;
        }
        if (flag) {
            System.out.print("Combination N:" + cnt + " ");
            System.out.println(combination);
        } else {
            System.out.printf("%d combinations - neither equals %d%n", cnt, target);
        }
    }
}
