import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> box = new LinkedHashMap<>();

        String user = scan.nextLine();
        while (!user.equals("stop")) {
            String email = scan.nextLine().toLowerCase();
            if (email.endsWith("com") || email.endsWith("uk") || email.endsWith("us")) {

            } else {
                box.putIfAbsent(user, email);
                box.put(user, email);
            }
            user = scan.nextLine();
        }

        box.
                forEach((u, e) -> System.out.printf("%s -> %s%n", u, e));
    }
}
