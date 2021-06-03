import java.util.Scanner;

public class DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double p1 = 0;
        double p1Cnt = 0;

        double p2 = 0;
        double p2Cnt = 0;

        double p3 = 0;
        double p3Cnt = 0;

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if (num % 2 == 0)
                p1Cnt++;
            if (num % 3 == 0)
                p2Cnt++;
            if (num % 4 == 0)
                p3Cnt++;
        }

        p1 = p1Cnt / n * 100;
        p2 = p2Cnt / n * 100;
        p3 = p3Cnt / n * 100;

        System.out.printf("%.2f%%%n",p1);
        System.out.printf("%.2f%%%n",p2);
        System.out.printf("%.2f%%%n",p3);
    }
}
