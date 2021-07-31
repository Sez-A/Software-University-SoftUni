import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] userNames = scan.nextLine().split(", ");
        for (String username : userNames) {
            if (isValidUser(username)) {
                System.out.println(username);
            }
        }
    }

    public static boolean isValidUser(String user) {
        if (user.length() < 3 || user.length() > 16) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            char symbol = user.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        return true;
    }
}
