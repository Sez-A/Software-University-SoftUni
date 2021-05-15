import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double currentWorldRecord = Double.parseDouble(scan.nextLine());
        double metres = Double.parseDouble(scan.nextLine());
        double swimPerMeter = Double.parseDouble(scan.nextLine());


       double delay = Math.floor(metres / 15) * 12.5;

        double needTime = (metres * swimPerMeter)+ delay;

        if (needTime >= currentWorldRecord) {
            double missingSeconds = needTime - currentWorldRecord;
            System.out.printf("No, he failed! He was %.2f seconds slower.%n", missingSeconds);
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.%n", needTime);
        }
    }
}
