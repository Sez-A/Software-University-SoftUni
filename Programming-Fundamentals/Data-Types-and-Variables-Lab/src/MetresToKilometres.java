import java.util.Scanner;

public class MetresToKilometres {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int metres = Integer.parseInt(scan.nextLine());
        double kilometres = metres / 1000.0;
        System.out.println(String.format("%.2f",kilometres));
    }
}
