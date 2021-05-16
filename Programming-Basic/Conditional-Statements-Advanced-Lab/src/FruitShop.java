import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        String dayOfWeek = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());
        double productPrice = 0;
        switch (dayOfWeek) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                switch (product) {
                    case "banana":
                        productPrice = quantity * 2.50;
                        break;
                    case "apple":
                        productPrice = quantity * 1.20;
                        break;
                    case "orange":
                        productPrice = quantity * 0.85;
                        break;
                    case "grapefruit":
                        productPrice = quantity * 1.45;
                        break;
                    case "kiwi":
                        productPrice = quantity * 2.70;
                        break;
                    case "pineapple":
                        productPrice = quantity * 5.50;
                        break;
                    case "grapes":
                        productPrice = quantity * 3.85;
                        break;
                }
                break;
            case "Saturday":
            case "Sunday":
                //плод	banana	apple	orange	grapefruit	kiwi	pineapple	grapes
                //цена	2.70	1.25	0.90	1.60	3.00	        5.60	4.20
                switch (product) {
                    case "banana":
                        productPrice = quantity * 2.70;
                        break;
                    case "apple":
                        productPrice = quantity * 1.25;
                        break;
                    case "orange":
                        productPrice = quantity * 0.9;
                        break;
                    case "grapefruit":
                        productPrice = quantity * 1.60;
                        break;
                    case "kiwi":
                        productPrice = quantity * 3.;
                        break;
                    case "pineapple":
                        productPrice = quantity * 5.60;
                        break;
                    case "grapes":
                        productPrice = quantity * 4.20;
                        break;
                }
                break;

        }
        if (productPrice != 0)
            System.out.printf("%.2f", productPrice);
        else
            System.out.println("error");
    }
}
