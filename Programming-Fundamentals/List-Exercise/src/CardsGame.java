import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstDeck = readIntList(scan);
        List<Integer> secondDeck = readIntList(scan);

        boolean firstDeckTrue = true;
        boolean secondDeckTrue = true;

        for (int i = 0; i <= firstDeck.size(); i++) {

            if (firstDeck.size() <= 0) {
                firstDeckTrue = false;
                break;
            }
            if (secondDeck.size() <= 0) {
                 secondDeckTrue = false;
                break;
            }

            int tempFirstDeck = firstDeck.get(0);
            int tempSecondDeck = secondDeck.get(0);

            if (tempFirstDeck == tempSecondDeck) {
                firstDeck.remove(0);
                secondDeck.remove(0);
                i--;
            } else if (firstDeck.get(i) > secondDeck.get(i)) {
                firstDeck.remove(0);
                secondDeck.remove(0);
                firstDeck.add(tempFirstDeck);
                firstDeck.add(tempSecondDeck);
                i--;

            } else if (secondDeck.get(i) > firstDeck.get(i)) {
                secondDeck.remove(0);
                firstDeck.remove(0);
                secondDeck.add(tempSecondDeck);
                secondDeck.add(tempFirstDeck);
                i--;
            }
        }
        int sum = 0;
        if (firstDeckTrue) {

            for (Integer number : firstDeck) {
                sum += number;
            }
            System.out.println(String.format("First player wins! Sum: %d", sum));
        }if(secondDeckTrue) {
            for (Integer number : secondDeck) {
                sum += number;
            }
            System.out.println(String.format("Second player wins! Sum: %d", sum));
        }

    }

    public static List<Integer> readIntList(Scanner scanner) {
        String[] numbersAsString = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String number : numbersAsString) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

}
