import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputHours = Integer.parseInt(scan.nextLine());
        int inputMinutes = Integer.parseInt(scan.nextLine());

        int timeAfter15Min = (inputHours * 60) + inputMinutes + 15;
        int hours = timeAfter15Min / 60;
        int minutes = timeAfter15Min % 60;

        if (hours > 23) {
            hours = 0;
        }

        System.out.printf("%d:%02d%n", hours, minutes);
    }
}
