package midexam05;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int health = 100;
        int bitcoins = 0;

        String[] input = scan.nextLine().split("\\|");

        for (int i = 0; i < input.length; i++) {
            String[] room = input[i].split("\\s+");
            switch (room[0]) {
                case "potion":
                    int currentHealth = health;
                    int amount = Integer.parseInt(room[1]);
                    health += amount;
                    if (health > 100) {
                        health = 100;
                        int quantity = 100 - currentHealth;
                        System.out.printf("You healed for %d hp.%n", quantity);
                    } else {
                        System.out.printf("You healed for %d hp.%n", amount);
                    }
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    int bitcoinsAmount = Integer.parseInt(room[1]);
                    System.out.printf("You found %d bitcoins.%n", bitcoinsAmount);
                    bitcoins += bitcoinsAmount;
                    break;

                default:
                    String monster = room[0];
                    int monsterPower = Integer.parseInt(room[1]);
                    health -= monsterPower;
                    if (health <= 0) {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d%n", i + 1);
                        return;
                    } else {
                        System.out.printf("You slayed %s.%n", monster);
                    }
                    break;
            }
        }

        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", bitcoins);
        System.out.printf("Health: %d%n", health);
    }
}
