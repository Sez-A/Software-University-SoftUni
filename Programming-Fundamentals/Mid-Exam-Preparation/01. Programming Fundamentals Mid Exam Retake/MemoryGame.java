package midexam01retake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListString sequence = Arrays.stream(scan.nextLine().split(s+))
                .collect(Collectors.toList());

        String command = scan.nextLine();
        int moves = 0;

        while (!command.equals(end)) {
            String[] tokens = command.split(s+);
            int firstIndex = Integer.parseInt(tokens[0]);
            int secondIndex = Integer.parseInt(tokens[1]);
            moves++;

            if (firstIndex  0  firstIndex = sequence.size()
                     firstIndex == secondIndex 
                    secondIndex  0  secondIndex = sequence.size()) {

                System.out.println(Invalid input! Adding additional elements to the board);
                for (int i = 0; i  2; i++) {
                    sequence.add(sequence.size()  2, -+moves + a);

                }

            } else {

                String firstElement = sequence.get(firstIndex);
                String secondElement = sequence.get(secondIndex);

                if (firstElement.equals(secondElement)) {
                    sequence.remove(firstIndex);
                    if (secondIndex  firstIndex) {
                        secondIndex -= 1;
                    }
                    sequence.remove(secondIndex);
                    System.out.printf(Congrats! You have found matching elements - %s!%n, firstElement);
                } else {
                    System.out.println(Try again!);
                }

                if (sequence.size() == 0) {
                    System.out.printf(You have won in %d turns!%n, moves);
                   return;
                }
            }
            command = scan.nextLine();
        }
        System.out.println(Sorry you lose ();
        for (String element  sequence) {
            System.out.print(element +  );
        }
    }
}
