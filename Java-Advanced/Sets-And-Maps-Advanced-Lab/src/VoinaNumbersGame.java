import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumbersGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while (rounds-- > 0) {

            Iterator<Integer> firstIterator = firstDeck.iterator();
            Integer firstCard = firstIterator.next();
            firstDeck.remove(firstCard);

            Iterator<Integer> secondIterator = secondDeck.iterator();
            Integer secondCard = secondIterator.next();
            secondDeck.remove(secondCard);

            if(firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if(firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }

        if(firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        }else if(secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }

    }
}
