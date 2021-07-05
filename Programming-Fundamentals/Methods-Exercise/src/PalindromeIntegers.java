import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")) {

            findPalindrome(input);

            input = scan.nextLine();
        }
    }

    public static void findPalindrome(String text) {
        String firstDigitAsString = "";
        String endDigitAsString = "";
        for (int i = 0; i < text.length(); i++) {
            char digit = text.charAt(i);
            firstDigitAsString = digit + "";
            char digitEnd = text.charAt(text.length() - 1);
            endDigitAsString = digitEnd + "";
            if (firstDigitAsString.equals(endDigitAsString)) {
                System.out.println("true");
                break;
            } else {
                System.out.println("false");
                break;
            }
        }
    }
}