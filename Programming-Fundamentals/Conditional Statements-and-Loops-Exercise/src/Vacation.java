import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleCnt = Integer.parseInt(scan.nextLine());
        String peopleType = scan.nextLine();
        String day = scan.nextLine();

        double price = 0.0;
        boolean flag = false;
        double priceWithDiscount = 1;
        if (peopleType.equals("Students")) {
            switch (day) {
                case "Friday":
                    price = peopleCnt * 8.45;
                    break;
                case "Saturday":
                    price = peopleCnt * 9.80;
                    break;
                case "Sunday":
                    price = peopleCnt * 10.46;
                    break;
            }
            if (peopleCnt >= 30) {
                priceWithDiscount = price - price * 0.15;
                flag = true;
            }
        } else if (peopleType.equals("Business")) {
            if (peopleCnt >= 100) {
                peopleCnt = peopleCnt - 10;
            }
            switch (day) {
                case "Friday":
                    price = peopleCnt * 10.90;
                    break;
                case "Saturday":
                    price = peopleCnt * 15.60;
                    break;
                case "Sunday":
                    price = peopleCnt * 16;
                    break;
            }
        } else if (peopleType.equals("Regular")) {
            switch (day) {
                case "Friday":
                    price = peopleCnt * 15;
                    break;
                case "Saturday":
                    price = peopleCnt * 20;
                    break;
                case "Sunday":
                    price = peopleCnt * 22.50;
                    break;
            }
            if (peopleCnt >= 10 && peopleCnt <= 20) {
                priceWithDiscount = price - price * 0.05;
                flag = true;
            }
        }
        if (flag) {
            System.out.printf("Total price: %.2f", priceWithDiscount);
        } else {
            System.out.println(String.format("Total price: %.2f", price));
        }
    }
}