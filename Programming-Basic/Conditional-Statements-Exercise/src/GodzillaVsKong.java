import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int extrasCnt = Integer.parseInt(scan.nextLine());
        double extraClothePrice = Double.parseDouble(scan.nextLine());

        double decorPrice = budget * 0.1;

        if (extrasCnt > 150) {
            extraClothePrice = extraClothePrice - (extraClothePrice * 0.1);
        }

        double totalCost = decorPrice + (extrasCnt * extraClothePrice);

        if (totalCost > budget) {
            System.out.println("Not enough money!");
            double neededMoney = totalCost - budget;
            System.out.printf("Wingard needs %.2f leva more.%n", neededMoney);
        } else {
            System.out.println("Action!");
            double leftMoney = budget - totalCost;
            System.out.printf("Wingard starts filming with %.2f leva left.%n", leftMoney);
        }
    }
}
