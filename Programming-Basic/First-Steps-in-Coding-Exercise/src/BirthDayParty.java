import java.util.Scanner;

public class BirthDayParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rentPrice = Integer.parseInt(scan.nextLine());

        double cakePrice = rentPrice * 0.2;

        double drinkPrice = cakePrice - (cakePrice * 0.45);

        double animatorPrice = rentPrice / 3.0;

        double neededMoney = rentPrice + cakePrice
                + drinkPrice + animatorPrice;

        System.out.printf("%.1f%n",neededMoney);
    }
}
