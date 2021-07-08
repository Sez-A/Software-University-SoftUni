import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativeAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = readIntList(scan);
        for (int i = 0; i < numbers.size() ; i++) {
            if(numbers.get(i) <0){
                numbers.remove(numbers.get(i));
                i--;
            }
        }
        if(numbers.isEmpty()){
            System.out.println("empty");
        }


        List<Integer> reversedNumbers = new ArrayList<>();

        for (int i = numbers.size() - 1; i >= 0 ; i--) {
        reversedNumbers.add(numbers.get(i));
        }

        print(reversedNumbers);
    }

    private static List<Integer> readIntList(Scanner scan) {
        String[] numbersAsString = scan.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String numberInString:numbersAsString) {
            numbers.add(Integer.parseInt(numberInString));
        }
        return numbers;
    }

    public static void print(List<Integer> numbersForPrint){
        for (Integer number:numbersForPrint
             ) {
            System.out.print(number + " ");
        }
    }
}
