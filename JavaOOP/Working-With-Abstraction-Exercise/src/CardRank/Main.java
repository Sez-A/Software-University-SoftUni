package CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        System.out.printf("%s:%n", input);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.ACE.ordinal(), CardRank.ACE);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.TWO.ordinal(), CardRank.TWO);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.THREE.ordinal(), CardRank.THREE);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.FOUR.ordinal(), CardRank.FOUR);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.FIVE.ordinal(), CardRank.FIVE);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.SIX.ordinal(), CardRank.SIX);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.SEVEN.ordinal(), CardRank.SEVEN);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.EIGHT.ordinal(), CardRank.EIGHT);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.NINE.ordinal(), CardRank.NINE);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.TEN.ordinal(), CardRank.TEN);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.JACK.ordinal(), CardRank.JACK);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.QUEEN.ordinal(), CardRank.QUEEN);
        System.out.printf("Ordinal value: %d; Name value: %s%n", CardRank.KING.ordinal(), CardRank.KING);


    }
}
