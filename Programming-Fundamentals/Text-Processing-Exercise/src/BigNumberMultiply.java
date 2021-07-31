import java.math.BigInteger;
import java.util.Scanner;

public class BigNumberMultiply {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numberAsString = scan.nextLine();
        int multiplier = Integer.parseInt(scan.nextLine());
        if (multiplier == 0) {
            System.out.println(0);
            return;
        }
        while (numberAsString.charAt(0) == '0') {
            numberAsString = numberAsString.substring(1);
        }
        StringBuilder result = new StringBuilder();
        int reminder = 0;

        for (int i = numberAsString.length() - 1; i >= 0; i--) {
            char valueForParse = numberAsString.charAt(i);
            int digit = Integer.parseInt(String.valueOf(valueForParse));
            int sum = 0;
            sum += (digit * multiplier + reminder);
            result.append(sum % 10);
            reminder = sum / 10;
        }
        if (reminder != 0) {
            result.append(reminder);
        }
        System.out.println(result.reverse());


    }
}


// don't forget reverse the result !