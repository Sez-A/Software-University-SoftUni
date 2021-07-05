import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        boolean isPasswordCorrect = isValidPassword(password);
        if(isPasswordCorrect){
            System.out.println("Password is valid");
        }
    }

    public static boolean isValidPassword(String password) {
        boolean isEnough = isLengthCorrect(password);
        boolean containsOnlyLettersOrAndDigit = containsDigitAndLetters(password);
        boolean minTwoDigits = twoDigitsMin(password);
        boolean isValid = isEnough && containsOnlyLettersOrAndDigit && minTwoDigits;
        return isValid;
    }

    public static boolean isLengthCorrect(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }

    public static boolean containsDigitAndLetters(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (!Character.isLetterOrDigit(symbol)) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    public static boolean twoDigitsMin(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (Character.isDigit(symbol)) {
                counter++;
                if(counter == 2){
                    break;
                }
            }
        }
        if(counter == 2){
            return true;
        }else{
            System.out.println("Password must have at least 2 digits");
            return false;
        }
    }
}
