import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstParticipantSeconds = Integer.parseInt(scan.nextLine());
        int secondParticipantSeconds = Integer.parseInt(scan.nextLine());
        int thirdParticipantSeconds = Integer.parseInt(scan.nextLine());

        int totalTime =
                firstParticipantSeconds
                        + secondParticipantSeconds + thirdParticipantSeconds;

        int minutes = totalTime / 60;
        int seconds = totalTime % 60;

        System.out.printf("%d:%02d", minutes, seconds);

    }
}
