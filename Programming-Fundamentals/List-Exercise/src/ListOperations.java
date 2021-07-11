import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = readStringList(scan);
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("Add")) {
                numbers.add(Integer.parseInt(tokens[1]));
            } else if (tokens[0].equals("Insert")) {
                int numberToInsert = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                try {
                    numbers.add(index, numberToInsert);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid index");
                }
            } else if (tokens[0].equals("Remove")) {
                int index = Integer.parseInt(tokens[1]);
                if (index >= numbers.size() || index < 0) {
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(index);
                }

            } else if (tokens[0].equals("Shift") && tokens[1].equals("left")) {
                int rotationCnt = Integer.parseInt(tokens[2]);
                for (int i = 0; i < rotationCnt; i++) {
                    int temp = numbers.get(0);
                    for (int j = 0; j < numbers.size() - 1; j++) {
                        int nextElement = numbers.get(j + 1);
                        numbers.set(j, nextElement);
                    }
                    numbers.set((numbers.size() - 1), temp);
                }

            } else if (tokens[0].equals("Shift") && tokens[1].equals("right")) {
                int rotationCnt = Integer.parseInt(tokens[2]);
                for (int i = 0; i < rotationCnt; i++) {
                    int temp = numbers.get(numbers.size() - 1);
                    for (int j = numbers.size() - 1; j > 0; j--) {
                        int nextElement = numbers.get(j - 1);
                        numbers.set(j, nextElement);
                    }
                    numbers.set(0, temp);
                }
            }
            command = scan.nextLine();
        }

        printList(numbers);

    }

    public static List<Integer> readStringList(Scanner scanner) {
        String[] numbersAsString = scanner.nextLine().split("\\s++");
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersAsString) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public static void printList(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

}
