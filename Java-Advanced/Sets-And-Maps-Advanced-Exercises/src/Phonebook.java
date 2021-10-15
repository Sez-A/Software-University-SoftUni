import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];
            phonebook.putIfAbsent(name, phoneNumber);
            phonebook.put(name, phoneNumber);
            input = scan.nextLine();
        }

        input = scan.nextLine();
        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                String number = phonebook.get(input);
                System.out.printf("%s -> %s%n", input, number);
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scan.nextLine();
        }
    }
}
