import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = readIntegerList(scan);
        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("Contains") && numbers.contains(Integer.parseInt(tokens[1]))) {
                System.out.println("Yes");
            } else if (tokens[0].equals("Contains")) {
                System.out.println("No such number");

            } else if (tokens[0].equals("Print") && tokens[1].equals("even")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 0) {
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                System.out.println();
            } else if (tokens[0].equals("Print") && tokens[1].equals("odd")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 != 0) {
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                System.out.println();
            }else if (tokens[0].equals("Get") && tokens[1].equals("sum")){
                int sum = 0;
                for (Integer number:numbers) {
                    sum += number;
                }
                System.out.println(sum);
            }else if(tokens[0].equals("Filter") && tokens[1].equals("<")){
                int num = Integer.parseInt(tokens[2]);
                for (Integer numbersInList: numbers) {
                    if(numbersInList < num){
                        System.out.print(numbersInList + " ");
                    }
                }
                System.out.println();
            }else if(tokens[0].equals("Filter") && tokens[1].equals(">")){
                int num = Integer.parseInt(tokens[2]);
                for (Integer numbersInList : numbers) {
                    if(numbersInList > num){
                        System.out.print(numbersInList + " ");
                    }
                }
                System.out.println();
            }else if (tokens[0].equals("Filter") && tokens[1].equals("<=")){
                int num = Integer.parseInt(tokens[2]);
                for (Integer numbersInList : numbers) {
                    if(numbersInList <= num){
                        System.out.print(numbersInList + " ");
                    }
                }
                System.out.println();
            }else if (tokens[0].equals("Filter") && tokens[1].equals(">=")){
                int num = Integer.parseInt(tokens[2]);
                for (Integer numbersInList : numbers) {
                    if(numbersInList >= num){
                        System.out.print(numbersInList + " ");
                    }
                }
                System.out.println();
            }

            command = scan.nextLine();
        }

    }

    public static List<Integer> readIntegerList(Scanner scanner) {
        String[] numbersAsString = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersAsString) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;


    }
}
