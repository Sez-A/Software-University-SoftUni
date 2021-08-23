package midexam04;

import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstEmployeeEfficiency = Integer.parseInt(scan.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scan.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scan.nextLine());

        int peopleCount = Integer.parseInt(scan.nextLine());

        int neededTime = 0;

        while (peopleCount > 0) {
            peopleCount = peopleCount - (firstEmployeeEfficiency +
                    secondEmployeeEfficiency + thirdEmployeeEfficiency);
            neededTime++;
            if (neededTime % 4 == 0) {
                neededTime++;
            }
        }
        System.out.println(String.format("Time needed: %dh.", neededTime));
    }
}
