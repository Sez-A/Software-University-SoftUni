package midexam03retake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = "";
        while (!(command = scan.nextLine()).equals("End")) {
            String[] tokens = command.split("\\s+");
            int index = Integer.parseInt(tokens[1]);
            switch (tokens[0]) {
                case "Shoot":
                    int power = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < targets.size()) {
                        Integer currentTarget = targets.get(index);
                        currentTarget -= power;
                        if (currentTarget <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, currentTarget);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < targets.size()) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(tokens[2]);
                    if (index + radius < targets.size() && index - radius >= 0) {
                        targets.subList(index - radius, index + radius + 1).clear();
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
        }


        for (int i = 0; i < targets.size(); i++) {
            if (i == targets.size() - 1) {
                System.out.print(targets.get(i));
            } else
                System.out.printf("%d|", targets.get(i));
        }
    }
}