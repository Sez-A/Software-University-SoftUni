package midexam01retake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// TODO This solution 88/100 in judge check for new solution!
public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        List<Integer> lift = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        boolean noSpace = false;
        while (!(people <= 0)) {
            if (hasSpace(lift)) {
                for (int i = 0; i < lift.size(); i++) {
                    Integer currentWagon = lift.get(i);
                    int emptySpace = 4 - currentWagon;

                    if (emptySpace <= 0) {

                    } else {
                        if (emptySpace == 4) {
                            if (people - emptySpace <= 0) {
                                emptySpace = people;
                            }
                            people -= emptySpace;
                        } else {
                            if (emptySpace > people) {
                                lift.set(i, currentWagon + people);
                                people = 0;
                                break;
                            } else
                                people -= emptySpace;
                            emptySpace += 4 - emptySpace;
                        }
                        lift.set(i, emptySpace);
                    }
                }
            } else {
                noSpace = true;
                break;
            }
        }

        if (!hasSpace(lift)) {
            System.out.println(String.format("There isn't enough space! %d people in a queue!", people));
            for (Integer wagon : lift) {
                System.out.print(wagon + " ");
            }
            return;
        }

        if (noSpace) {
            System.out.println(String.format("There isn't enough space! %d people in a queue!", people));

        } else {
            System.out.println("The lift has empty spots!");
        }
        for (Integer wagon : lift) {
            System.out.print(wagon + " ");
        }
    }

    private static boolean hasSpace(List<Integer> lift) {
        boolean hasSpace = false;
        for (Integer wagon : lift) {
            if (wagon < 4) {
                hasSpace = true;
                break;
            }
        }
        return hasSpace;
    }
}
