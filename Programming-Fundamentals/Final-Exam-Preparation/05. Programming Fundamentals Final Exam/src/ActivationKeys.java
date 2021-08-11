import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String activationKey = scan.nextLine();
        StringBuilder sb = new StringBuilder(activationKey);

        String command = scan.nextLine();
        while (!command.equals("Generate")) {
            String[] tokens = command.split(">>>");
            switch (tokens[0]) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String target = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);

                    if (target.equals("Upper")) {
                        sb.replace(startIndex, endIndex, sb.substring(startIndex, endIndex).toUpperCase());
                    } else if (target.equals("Lower")) {
                        sb.replace(startIndex, endIndex, sb.substring(startIndex, endIndex).toLowerCase());
                    }

                    System.out.println(sb.toString());
                    activationKey = sb.toString();
                    break;
                case "Slice":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int lastIndex = Integer.parseInt(tokens[2]);
                    sb.replace(firstIndex, lastIndex, " ".trim());
                    System.out.println(sb);
                    activationKey = sb.toString();
                    break;

            }
            command = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}
