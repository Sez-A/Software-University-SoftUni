package practical_exam_23_10_2021;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> ingredients = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> freshness = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int pearSourCnt = 0;
        int theHarvestCnt = 0;
        int appleHinnyCnt = 0;
        int highFashionCnt = 0;

        boolean done = false;
        while (!ingredients.isEmpty()) {
            if (freshness.isEmpty()) {
                break;
            }
            int ingredientInd = 0;
            int freshnessInd = freshness.size() - 1;

            Integer ingredient = ingredients.get(ingredientInd);
            Integer f = freshness.get(freshnessInd);

            if (ingredient == 0) {
                ingredients.remove(ingredientInd);
                // ingredient = ingredients.get(ingredientInd);
                continue;
            }
            int sum = ingredient * f;
            boolean isMixed = false;
            switch (sum) {
                case 150:
                    pearSourCnt++;
                    isMixed = true;
                    break;
                case 250:
                    theHarvestCnt++;
                    isMixed = true;
                    break;
                case 300:
                    appleHinnyCnt++;
                    isMixed = true;
                    break;
                case 400:
                    highFashionCnt++;
                    isMixed = true;
                    break;
            }
            if (isMixed) {
                ingredients.remove(ingredientInd);
                freshness.remove(freshnessInd);
            } else {
                freshness.remove(freshnessInd);
                ingredients.add(ingredients.size() , ingredient + 5);
                ingredients.remove(ingredientInd);
            }
//                if (pearSourCnt >= 4 && theHarvestCnt >= 4 && appleHinnyCnt >= 4
//                        && highFashionCnt >= 4) {
//                    done = true;
//                    break;
//                }

        }
        if (pearSourCnt >= 1 && theHarvestCnt >= 1 && appleHinnyCnt >= 1 && highFashionCnt >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            int sum = 0;
            for (Integer ingredient : ingredients) {
                sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Apple Hinny", appleHinnyCnt);
        cocktails.put("High Fashion", highFashionCnt);
        cocktails.put("Pear Sour", pearSourCnt);
        cocktails.put("The Harvest", theHarvestCnt);

        cocktails
                .entrySet()
                .stream()
                .filter(c -> c.getValue() >= 1)
                .forEach(c -> System.out.printf(" # %s --> %d%n", c.getKey(), c.getValue()));
    }
}
