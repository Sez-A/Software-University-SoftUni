import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        int numForPrinting = 1;

        while (numForPrinting <= n) {
            System.out.println(numForPrinting);
            numForPrinting = (numForPrinting * 2) + 1;
        }
    }
}
