import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();

        if (destination.equals("End"))
            return;

        double neededMoney = Double.parseDouble(scan.nextLine());
        while (!destination.equals("End")) {

            double currentMoney = 0;
            while (currentMoney < neededMoney) {
                currentMoney += Double.parseDouble(scan.nextLine());
            }
            System.out.println("Going to " + destination + "!");
            destination = scan.nextLine();
            if (destination.equals("End"))
                break;
            neededMoney = Double.parseDouble(scan.nextLine());
        }
    }
}
