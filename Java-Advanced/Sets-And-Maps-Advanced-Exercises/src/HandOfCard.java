import java.util.*;

public class HandOfCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Set<String>> deck = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] splitCards = tokens[1].split(", ");
            deck.putIfAbsent(name, new HashSet<>());
            Set<String> cards = deck.get(name);
            for (String card : splitCards) {
                cards.add(card);
            }

            deck.put(name, cards);

            input = scan.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : deck.entrySet()) {
            int sum = 0;
            Set<String> strings = deck.get(entry.getKey());
            for (String card : strings) {
                sum += generatePower(card) * generateType(card);
            }

            System.out.println(String.format("%s: %d",entry.getKey(),sum));
        }
    }

    private static int generateType(String card) {
        String type = "";

            type = card.substring(card.length() - 1);
            switch (type) {
                case "C":
                    return 1;
                case "D":
                    return 2;
                case "H":
                    return 3;
                case "S":
                    return 4;
                default:
                    return 0;
            }
        }



    private static int generatePower(String card) {
        String type = "";

            type = card.substring(0, card.length() - 1);
            switch (type) {
                case "2":
                    return 2;
                case "3":
                    return 3;
                case "4":
                    return 4;
                case "5":
                    return 5;
                case "6":
                    return 6;
                case "7":
                    return 7;
                case "8":
                    return 8;
                case "9":
                    return 9;
                case "10":
                    return 10;
                case "J":
                    return 11;
                case "Q":
                    return 12;
                case "K":
                    return 13;
                case "A":
                    return 14;
                default:
                    return 0;

            }

    }
}
