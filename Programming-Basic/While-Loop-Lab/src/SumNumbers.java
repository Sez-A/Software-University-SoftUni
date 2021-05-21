import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int targetNum = Integer.parseInt(scan.nextLine());

        int sum = 0;
        while (!(sum >= targetNum)) {
            sum += Integer.parseInt(scan.nextLine());
        }
        System.out.println(sum);
    }
}
