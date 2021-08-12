import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Pattern pattern = Pattern.compile("@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+");
        Pattern productGroupPattern = Pattern.compile("[0-9]");
        List<String> barcodes = new ArrayList<>();
        while (n-- > 0) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                Matcher productGroupMatcher = productGroupPattern.matcher(input);
                boolean flag = false;
                String productGroup = "";
                while (productGroupMatcher.find()) {
                    flag = true;
                    productGroup += productGroupMatcher.group();
                }
                if(!flag) {
                    productGroup = "00";
                }
                System.out.printf("Product group: %s%n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
