package demo1;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());

        double totalPlunder = 0;
        for (int i = 1; i <= days; i++) {
            totalPlunder += dailyPlunder;
            if (i % 3 == 0) {
                totalPlunder += (dailyPlunder * 0.5);
            }

            if (i % 5 == 0) {
                totalPlunder = totalPlunder - (totalPlunder * 0.3);
            }

        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", totalPlunder);
        } else {
            double percent = (totalPlunder /expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.%n", percent);
        }
    }
}
