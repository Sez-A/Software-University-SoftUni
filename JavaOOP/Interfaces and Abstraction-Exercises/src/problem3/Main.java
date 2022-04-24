package problem3;

import problem1.Citizen;
import problem2.Birthable;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();
        String line;
        while (!(line = scan.nextLine()).equals("End")) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Citizen":
                    birthables.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Pet":
                    birthables.add(new Pet(tokens[1], tokens[2]));
                    break;
            }
        }

        String targetYear = scan.nextLine();
        for (Birthable birthable : birthables) {
            if(birthable.getBirthDate().endsWith(targetYear)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
