package midexam01retake;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LiftProb {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        List<Integer> lift = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = 0; i < lift.size(); i++) {
            if (lift.get(i) < 4) {
                if (people >= 4 - lift.get(i)) {
                    people -= 4 - lift.get(i);
                    lift.set(i, 4);
                } else {
                    lift.set(i, lift.get(i) + people);
                    people = 0;
                }
            }
        }

        boolean hasSpace = false;
        for (Integer wagon : lift) {
            if (wagon < 4) {
                hasSpace = true;
                break;
            }
        }

        if (hasSpace) {
            System.out.println("The lift has empty spots!");
        } else if (people > 0) {
            System.out.println(String.format("There isn't enough space! %d people in a queue!", people));
        } else {
            for (Integer wagon : lift) {
                System.out.print(wagon + " ");
            }
            return;
        }
        for (Integer wagon : lift) {
            System.out.print(wagon + " ");
        }

    }
}