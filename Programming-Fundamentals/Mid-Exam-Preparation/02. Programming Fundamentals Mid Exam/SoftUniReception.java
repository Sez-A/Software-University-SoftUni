package midexam02;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstEmployeeEfficiency = Integer.parseInt(scan.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scan.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scan.nextLine());

        int studentsCount = Integer.parseInt(scan.nextLine());

        int neededHours = 0;
        while (!(studentsCount <= 0)) {

            studentsCount -= firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
            neededHours++;
            if (neededHours % 4 == 0) {
                neededHours++;
            }
        }

        System.out.printf("Time needed: %dh.",neededHours);
    }
}