package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        System.out.printf("%s:%n", input);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardSuit.CLUBS.ordinal(), CardSuit.CLUBS);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardSuit.DIAMONDS.ordinal(), CardSuit.DIAMONDS);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardSuit.HEARTS.ordinal(), CardSuit.HEARTS);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardSuit.SPADES.ordinal(), CardSuit.SPADES);
    }
}
