import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double neededMoney = Double.parseDouble(scan.nextLine());
        double currentMoney = Double.parseDouble(scan.nextLine());


        int spendDaysCnt = 0;
        int days = 0;

        boolean cantSave = false;
        while (currentMoney < neededMoney) {


            if (spendDaysCnt >= 5) {
                cantSave = true;
                break;
            }
            if (currentMoney <= 0) {
                currentMoney = 0;
            }

            String actionType = scan.nextLine();
            double moneyAmount = Double.parseDouble(scan.nextLine());

            if (actionType.equals("save")) {
                currentMoney += moneyAmount;
                spendDaysCnt = 0;
            } else if (actionType.equals("spend")) {
                spendDaysCnt++;
                currentMoney -= moneyAmount;
            }
            days++;
            if (currentMoney >= neededMoney) {
                break;
            }
        }

        if (cantSave) {
            System.out.println("You can't save the money.");
            System.out.println(days);
        } else {
            System.out.printf("You saved the money for %d days.%n", days);
        }
    }
}
