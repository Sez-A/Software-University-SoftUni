import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double depositedAmount = Double.parseDouble(scan.nextLine());
        int months = Integer.parseInt(scan.nextLine());
        double interestRate = Double.parseDouble(scan.nextLine()) / 100;

        //1. изчисляваме натрупаната лихва: 200 * 5.7% = 11.4лв.
        double accruedInterest = depositedAmount * interestRate;
        //2. изчисляваме лихвата за 1 месец: 11.4лв./12 месеца = 0.95лв
        double interestForMonth = accruedInterest / 12;
        //3. общата сума е 200лв депозит + (3 (срок на депозита) * 0.95 лв)

        double toReceive = depositedAmount + (months * interestForMonth);

        System.out.printf("%.2f%n", toReceive);
    }
}
