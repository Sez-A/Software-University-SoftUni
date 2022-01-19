package february_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> firstBox = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondBox = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int firstBoxInd = 0;
        int secondBoxInd = secondBox.size() - 1;
        int claimedItems = 0;
        int sum;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            sum = 0;

            Integer firstItem = firstBox.get(firstBoxInd);
            Integer secondItem = secondBox.get(secondBoxInd);
            sum += firstItem + secondItem;

            if (sum % 2 == 0) {
                claimedItems += sum;
                firstBox.remove(firstBoxInd);
                secondBox.remove(secondBoxInd--);
            } else {
                Integer lastItem = secondBox.remove(secondBoxInd--);
                firstBox.add(lastItem);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }
    }
}
