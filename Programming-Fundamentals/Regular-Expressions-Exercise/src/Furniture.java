import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = ">>(?<name>[A-Z]+[a-z]*)<<(?<price>[0-9]+\\.?[0-9]+)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> furniture = new ArrayList<>();
        double finalPrice = 0;
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furniture.add(name);
                finalPrice += price * quantity;
            }
            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture
                .forEach(f -> System.out.println(f));
        System.out.println(String.format("Total money spend: %.2f",finalPrice));
    }
}
