import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int product = 0;
        for (int i = n; i <= n ; i++) {
            for (int j = 1; j <= 10 ; j++) {
                product = i * j;
                System.out.printf("%d X %d = %d%n",i,j,product);
            }
        }
    }
}
