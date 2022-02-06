package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rank = scan.nextLine();
        String suit = scan.nextLine();

        int power = CardRank.valueOf(rank.toUpperCase()).getPower() + CardSuit.valueOf(suit.toUpperCase()).getPower();

        System.out.printf("Card name: %s of %s; Card power: %d%n", rank, suit, power);
    }
}
