import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int budget = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int fisherManCnt = Integer.parseInt(scan.nextLine());
        double rentPrice = 0;
        switch (season) {
            case "Spring":
                rentPrice = 3000;
                break;
            case "Summer":
            case "Autumn":
                rentPrice = 4200;
                break;
            case "Winter":
                rentPrice = 2600;
                break;
        }

        if (fisherManCnt <= 6)
            rentPrice = rentPrice - (rentPrice * 0.1);
        else if (fisherManCnt <= 11)
            rentPrice = rentPrice - (rentPrice * 0.15);
        else if (fisherManCnt >= 12)
            rentPrice = rentPrice - (rentPrice * 0.25);

        if (fisherManCnt % 2 == 0 && !(season.equals("Autumn"))) {
            rentPrice = rentPrice - (rentPrice * 0.05);
        }
        if (rentPrice <= budget) {
            System.out.printf("Yes! You have %.2f leva left.%n", Math.abs(budget - rentPrice));

        } else {
            System.out.printf("Not enough money! You need %.2f leva.%n", Math.ceil(rentPrice - budget));
        }
    }
}
