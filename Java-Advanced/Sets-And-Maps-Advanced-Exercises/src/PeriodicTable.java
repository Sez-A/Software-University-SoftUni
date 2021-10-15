import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Set<String> elements = new TreeSet<>();
        while (n-- > 0) {
            String[] line = scan.nextLine().split("\\s+");
            for (int i = 0; i < line.length; i++) {
                String element = line[i];
                elements.add(element);
            }
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }

    }
}
