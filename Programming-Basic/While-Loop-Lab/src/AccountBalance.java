import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        double accountBalance = 0;
        while (!input.equals("NoMoreMoney")) {
            double payment = Double.parseDouble(input);

            if (payment < 0) {
                System.out.println("Invalid operation!");
                break;
            } else {
                System.out.printf("Increase: %.2f%n", payment);
                accountBalance += payment;
            }
            input = scan.nextLine();
        }

        System.out.printf("Total: %.2f%n", accountBalance);
    }
}
