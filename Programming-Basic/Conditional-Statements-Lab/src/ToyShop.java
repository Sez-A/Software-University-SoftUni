import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double vacationCost = Double.parseDouble(scan.nextLine());
        int puzzelNumber = Integer.parseInt(scan.nextLine());
        int talkingDollNumber = Integer.parseInt(scan.nextLine());
        int teddyBearNumber = Integer.parseInt(scan.nextLine());
        int minionsNumber = Integer.parseInt(scan.nextLine());
        int truckNumber = Integer.parseInt(scan.nextLine());

        double puzzelCost = 2.60 * puzzelNumber;
        double talkingDollCost = 3 * talkingDollNumber;
        double teddyBearCost = 4.10 * teddyBearNumber;
        double minionCost = 8.20 * minionsNumber;
        double truckCost = 2 * truckNumber;

        double AllProducts = puzzelNumber + talkingDollNumber + teddyBearNumber + minionsNumber + truckNumber;
        double CostOfAllProducts = puzzelCost + talkingDollCost + teddyBearCost + minionCost + truckCost;

        if (AllProducts >= 50) {
            CostOfAllProducts = CostOfAllProducts * 0.75;

        }
        double finalPrice = CostOfAllProducts * 0.9;
        if (finalPrice >= vacationCost) {
            double moneyLeft = finalPrice - vacationCost;

            System.out.printf("Yes! %.2f lv left.%n", moneyLeft);
        } else {
            double moneyNeed = vacationCost - finalPrice;
            System.out.printf("Not enough money! %.2f lv needed.%n", moneyNeed);
        }
    }
}
