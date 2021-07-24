import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String commandName = tokens[0];
            String userName = tokens[1];
            if (commandName.equals("register")) {
                String plate = tokens[2];
                if (users.containsKey(userName)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", plate);
                } else {
                    users.putIfAbsent(userName, null);
                   // String count = users.get(userName);
                    users.put(userName, plate);
                    System.out.printf("%s registered %s successfully%n", userName, plate);
                }

            } else {
                if (!users.containsKey(userName)){
                    System.out.println(String.format("ERROR: user %s not found",userName));
                }else{
                    users.remove(userName);
                    System.out.println(String.format("%s unregistered successfully",userName));
                }
            }
        }
        users
                .entrySet()
                .forEach(u -> System.out.println(String.format("%s => %s",u.getKey(),u.getValue())));
    }
}
