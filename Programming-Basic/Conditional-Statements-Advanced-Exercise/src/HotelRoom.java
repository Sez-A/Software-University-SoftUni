import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String month = scan.nextLine();
        int nightCnt = Integer.parseInt(scan.nextLine());
        double apartmentPrice = 0;
        double studioPrice = 0;
        if ((nightCnt > 7 && nightCnt < 14 && (month.equals("May") || month.equals("October")))) {
            studioPrice = nightCnt * 50;
            studioPrice = studioPrice - (0.05 * studioPrice);
            apartmentPrice = nightCnt * 65;
        } else if ((nightCnt > 14) && (month.equals("May") || month.equals("October"))) {
            studioPrice = nightCnt * 50;
            studioPrice = studioPrice - (0.3 * studioPrice);
            apartmentPrice = nightCnt * 65;
        } else if (month.equals("May") || month.equals("October")) {
            studioPrice = nightCnt * 50;
            apartmentPrice = nightCnt * 65;
        } else if ((nightCnt > 14) && (month.equals("June") || month.equals("September"))) {
            studioPrice = nightCnt * 75.20;
            studioPrice = studioPrice - (0.2 * studioPrice);
            apartmentPrice = nightCnt * 68.70;
        } else if (month.equals("June") || month.equals("September")) {
            studioPrice = nightCnt * 75.20;
            apartmentPrice = nightCnt * 68.70;
        } else if (month.equals("July") || month.equals("August")) {
            studioPrice = nightCnt * 76;
            apartmentPrice = nightCnt * 77;
        }
        if (nightCnt > 14) {
            apartmentPrice = apartmentPrice - (apartmentPrice * 0.1);
        }
        System.out.printf("Apartment: %.2f lv.", apartmentPrice);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", studioPrice);
    }
}