package midexam05;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int studentCnt = Integer.parseInt(scan.nextLine());
        int lecturesCnt = Integer.parseInt(scan.nextLine());
        int additionalBonus = Integer.parseInt(scan.nextLine());

        int maxAttendances = 0;
        double maxBonus = Double.MIN_VALUE;

        for (int i = 0; i < studentCnt; i++) {

            int currentAttendances = Integer.parseInt(scan.nextLine());


            double totalBonus = ((1.0 * currentAttendances / lecturesCnt) * (5 + additionalBonus));

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxAttendances = currentAttendances;
            }
        }


        System.out.printf("Max Bonus: %d.%n", Math.round(maxBonus));
        System.out.printf("The student has attended %d lectures.%n", maxAttendances);
    }
}
