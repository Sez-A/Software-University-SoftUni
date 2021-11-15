import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String dayType = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        int price = 0;
        if (age <= 18) {
            switch (dayType) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
            }
        } else if (age <= 64) {
            switch (dayType) {
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
            }
        } else if (age <= 122) {
            switch (dayType) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
            }
        }
        if(age < 0){
            System.out.println("Error!");
        }else {
            System.out.println(price + "$");
        }
    }
}
