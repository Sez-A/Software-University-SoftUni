import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        String day = scan.nextLine();
        boolean isOpen = hour >= 10 && hour <= 18;
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
            case "Saturday":
                if (isOpen)
                    System.out.println("open");
                else System.out.println("closed");
                break;
            default:
                System.out.println("closed");
        }
    }
}
