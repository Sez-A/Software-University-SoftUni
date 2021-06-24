import java.sql.SQLOutput;
import java.util.Scanner;

public class SpecialSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbersAsString = scan.nextLine().split(" ");
        int specialNumbers = Integer.parseInt(scan.nextLine());

        int[] numbers = new int[numbersAsString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }
        for (int i = 0; i < numbers.length  ; i++) {
            for (int j = i; j < numbers.length - 1 ; j++) {
                if (specialNumbers == numbers[i] + numbers[j + 1]) {
                    System.out.print(numbers[i] + " " + numbers[j + 1] );
                    System.out.println();
                }
            }
        }
    }
}
