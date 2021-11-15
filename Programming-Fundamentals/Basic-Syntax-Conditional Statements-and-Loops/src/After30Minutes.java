import java.util.Scanner;

public class After30Minutes {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int sumTime = hour * 60 + minutes + 30;
        hour = sumTime / 60;
        if(hour >= 24) {
            hour = 0;
        }
        minutes =   sumTime % 60;
        System.out.printf("%d:%02d",hour,minutes);
    }
}
