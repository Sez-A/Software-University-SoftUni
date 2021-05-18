import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int examHour = Integer.parseInt(scan.nextLine()) * 60;
        int examMinutes = Integer.parseInt(scan.nextLine());
        int arriveHour = Integer.parseInt(scan.nextLine()) * 60;
        int arriveMinutes = Integer.parseInt(scan.nextLine());

        int arriveTime = arriveHour + arriveMinutes;
        int examTime = examHour + examMinutes;

        boolean late = arriveTime > examTime;
        boolean onTime = examTime - arriveTime <= 30;

        if (late) {
            System.out.println("Late");
            int lateMinutes = arriveTime - examTime;
            if (lateMinutes >= 60) {
                int lateHour = lateMinutes / 60;
                lateMinutes = lateMinutes % 60;
                System.out.printf("%d:%02d hours after the start%n", lateHour, lateMinutes);
            } else {
                System.out.printf("%d minutes after the start%n", lateMinutes);
            }
        } else if (onTime) {
            if (examTime == arriveTime) {
                System.out.println("On time");
            } else {
                System.out.printf("on time %d minutes before the start", examTime - arriveTime);
            }
        } else {
            System.out.println("Early");
            int earlyMinutes = examTime - arriveTime;
            if (earlyMinutes >= 60) {
                int earlyHour = earlyMinutes / 60;
                earlyMinutes %= 60;
                System.out.printf("%d:%02d hours before the start%n", earlyHour, earlyMinutes);
            } else {
                System.out.printf("%d minutes before the start", earlyMinutes);
            }
        }
    }
}
