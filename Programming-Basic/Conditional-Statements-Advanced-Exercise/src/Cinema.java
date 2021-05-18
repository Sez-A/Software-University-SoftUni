import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String projectionType = scan.nextLine();
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        double ticketPrice = 0;
        switch (projectionType) {
            case "Premiere":
                ticketPrice = 12.0;
                break;
            case "Normal":
                ticketPrice = 7.5;
                break;
            case "Discount":
                ticketPrice = 5.0;
                break;
        }

        System.out.printf("%.2f leva%n", rows * cols * ticketPrice);
    }
}
