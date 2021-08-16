package demo1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scan.nextLine().split(">")).
                map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scan.nextLine().split(">")).
                map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        while (!command.equals("Retire")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Fire": {
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);

                    if (validIndex(index, warShip)) {
                        Integer currentSection = warShip.get(index);
                        warShip.set(index, currentSection - damage);
                        if (warShip.get(index) <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                }
                break;
                case "Defend": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damage = Integer.parseInt(tokens[3]);

                    if (validIndex(startIndex, pirateShip)
                            && validIndex(endIndex, pirateShip)) {

                        for (int i = startIndex; i <= endIndex; i++) {
                            Integer currentSection = pirateShip.get(i);
                            pirateShip.set(i, currentSection - damage);
                            if (pirateShip.get(i) <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                }
                break;

                case "Repair": {
                    int index = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    if (validIndex(index, pirateShip)) {
                        if (pirateShip.get(index) + health >= maxHealth) {
                            pirateShip.set(index, maxHealth);
                        } else {
                            pirateShip.set(index, pirateShip.get(index) + health);
                        }
                    }
                }
                break;

                case "Status":
                    double target = maxHealth * 0.2;
                    int sectionCnt = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        if (pirateShip.get(i) < target) {
                            sectionCnt++;
                        }
                    }

                    System.out.printf("%d sections need repair.%n", sectionCnt);
                    break;
            }
            command = scan.nextLine();
        }

        int pirateShipStatus = 0;
        for (Integer section : pirateShip) {
            pirateShipStatus += section;
        }
        int warShipStatus = 0;
        for (Integer section : warShip) {
            warShipStatus += section;
        }

        System.out.printf("Pirate ship status: %d%n", pirateShipStatus);
        System.out.printf("Warship status: %d%n", warShipStatus);
    }

    private static boolean validIndex(int index, List<Integer> list) {
        if (index >= 0 && index < list.size()) {
            return true;
        }
        return false;
    }
}