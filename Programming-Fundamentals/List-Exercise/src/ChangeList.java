import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> numbers = readList(scan);
        String input = scan.nextLine();

        while(!input.equals("end")){
            String [] tokens = input.split(" ");
            if(tokens[0].equals("Delete")){
                for (int i = 0; i < numbers.size() ; i++) {
                    numbers.remove(tokens[1]);
                }
            }else if(tokens[0].equals("Insert")){
                String numberToInsert = tokens[1];
                int index = Integer.parseInt(tokens[2]);
                numbers.add(index,numberToInsert);
            }

            input = scan.nextLine();
        }
        printNumbers(numbers);
    }

    public static List<String> readList (Scanner scanner){
        String [] numbersAsString = scanner.nextLine().split(" ");

        List<String> numbers = new ArrayList<>();

        for (String number : numbersAsString) {
            numbers.add(number);
        }
        return numbers;
    }

    public static void printNumbers(List<String> numbers){
        for (String number : numbers) {
            System.out.print(number + " ");
        }
    }
}
