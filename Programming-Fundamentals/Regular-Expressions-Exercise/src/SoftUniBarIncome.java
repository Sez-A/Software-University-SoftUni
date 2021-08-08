import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line;
        String regex =
                "^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalIncome = 0.0;
        while (!(line = scan.nextLine()).equals("end of shift")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {

                String customerName = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double totalPrice = price * count;
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f%n", customerName, product, totalPrice);
            }
        }
        System.out.printf("Total income: %.2f%n", totalIncome);
    }
}
