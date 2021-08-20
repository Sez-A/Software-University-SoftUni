import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Pattern pattern = Pattern.compile("([\\=\\/])(?<destination>[A-Z][A-Za-z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();
        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinations.add(destination);
        }
        int travelPoints = 0;

        System.out.print("Destinations: ");
        for (int i = 0; i < destinations.size(); i++) {
            if (i == destinations.size() - 1) {
                System.out.print(destinations.get(i));
            } else {
                System.out.print(destinations.get(i) + ", ");
            }

            travelPoints += destinations.get(i).length();
        }
        System.out.println();
        System.out.println("Travel Points: " + travelPoints);
    }
}
