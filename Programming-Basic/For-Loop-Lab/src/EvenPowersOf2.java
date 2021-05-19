import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int num = 2;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.printf("%.0f%n", Math.pow(num, i));
            }
        }
    }
}
