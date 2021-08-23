package midexam03retake;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int energy = Integer.parseInt(scan.nextLine());

        int wins = 0;
        String command = "";
        while (!(command = scan.nextLine()).equals("End of battle")) {
            int distance = Integer.parseInt(command);

            if (energy >= distance) {
                wins++;
                energy -= distance;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", wins, energy);
                return;
            }

            if (wins % 3 == 0) {
                energy += wins;
            }


        }

        System.out.printf("Won battles: %d. Energy left: %d%n", wins, energy);
    }
}
