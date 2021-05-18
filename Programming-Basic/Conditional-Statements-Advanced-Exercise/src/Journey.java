import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String destination = "";
        String vacationType = "";
        double camp = 0;
        double hotel = 0;
        double moneySpend = 1;

        if (budget <= 100) {
            if (season.equals("summer")) {
                destination = "Bulgaria";
                vacationType = "Camp";
                moneySpend = camp = budget * 0.30;
            } else if (season.equals("winter")) {
                vacationType = "Hotel";
                destination = "Bulgaria";
                moneySpend = hotel = budget * 0.70;
            }
        } else if (budget > 100 && budget <= 1000) {
            if (season.equals("summer")) {
                vacationType = "Camp";
                destination = "Balkans";
                moneySpend = camp = budget * 0.40;
            } else if (season.equals("winter")) {
                vacationType = "Hotel";
                destination = "Balkans";
                moneySpend = hotel = budget * 0.80;
            }
        } else if (budget > 1000) {
            destination = "Europe";
            vacationType = "Hotel";
            moneySpend = hotel = budget * 0.90;
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", vacationType, moneySpend);
    }
}
