import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        String command = "";

        while (!(command = scan.nextLine()).equals("Done")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "TakeOdd":
                    String temp = "";
                    for (int i = 1; i < password.length(); i += 2) {
                        temp += password.charAt(i);
                    }
                    password = temp;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String substring = password.substring(index, index + length);
                    password = password.replaceFirst(substring, " ".trim());
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substringForRemove = tokens[1];
                    String substitute = tokens[2];
                    if (password.contains(substringForRemove)) {
                        password = password.replaceAll(substringForRemove, substitute.trim());
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
        }
        System.out.printf("Your password is: %s%n", password);
    }
}
