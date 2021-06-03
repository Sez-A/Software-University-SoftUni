import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        double p1 = 0;
        double p1Cnt = 0;

        double p2 = 0;
        double p2Cnt = 0;

        double p3 = 0;
        double p3Cnt = 0;

        double p4 = 0;
        double p4Cnt = 0;

        double p5 = 0;
        double p5Cnt = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number < 200)
                p1Cnt++;
            else if (number <= 399)
                p2Cnt++;
            else if (number <= 599)
                p3Cnt++;
            else if (number <= 799)
                p4Cnt++;
            else
                p5Cnt++;
        }

        p1 = p1Cnt / n * 100;
        p2 = p2Cnt / n * 100;
        p3 = p3Cnt / n * 100;
        p4 = p4Cnt / n * 100;
        p5 = p5Cnt / n * 100;

        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%%n", p3);
        System.out.printf("%.2f%%%n", p4);
        System.out.printf("%.2f%%%n", p5);
    }
}
