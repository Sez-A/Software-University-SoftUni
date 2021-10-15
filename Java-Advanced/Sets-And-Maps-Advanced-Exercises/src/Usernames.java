import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Usernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> names = new LinkedHashSet<>();
        for (int i = 0; i < n ; i++) {
            String line = scan.nextLine();
            names.add(line);
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
