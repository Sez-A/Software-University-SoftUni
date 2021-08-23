package demo1;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> chest = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        String command = scan.nextLine();
        while (!command.equals("Yohoho!")) {

            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        boolean contained = false;
                        for (int j = 0; j < chest.size(); j++) {
                            if (chest.get(j).toLowerCase().equals(tokens[i].toLowerCase())) {
                                contained = true;
                            }
                        }
                        if (!contained) {
                            chest.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    try {
                        chest.add(chest.remove(index));
                    } catch (IndexOutOfBoundsException e) {

                    }
                    break;

                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    if (count >= chest.size()) {
                        System.out.println(String.join(", ", chest));
                        chest.clear();
                    } else {
                        List<String> itemsForRemove = new ArrayList<>();
                        for (int i = chest.size() - count; i < chest.size(); i++) {
                            if (i == chest.size() - 1) {
                                System.out.println(chest.get(i));
                            } else {
                                System.out.print(chest.get(i) + ", ");
                            }
                            itemsForRemove.add(chest.get(i));
                        }

                        for (String item : itemsForRemove) {
                            for (int i = 0; i < chest.size(); i++) {
                                if (item.equals(chest.get(i))) {
                                    chest.remove(i);
                                    break;
                                }
                            }
                        }
                    }

                    break;
            }

            command = scan.nextLine();

        }


        if (chest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0.0;
            for (String item : chest) {
                sum += item.length();
            }

            sum /= chest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", sum);
        }
    }
}
