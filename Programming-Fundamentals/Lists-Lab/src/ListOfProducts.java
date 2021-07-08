import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String currentProduct = scan.nextLine();
            products.add(currentProduct);
        }
	Collections.sort(products);
        int i = 1;
        for (String product : products) {
            while (i <= products.size()){
                System.out.println(String.format("%d.%s",i,product));
                i++;
                break;
            }
        }
    }
}
