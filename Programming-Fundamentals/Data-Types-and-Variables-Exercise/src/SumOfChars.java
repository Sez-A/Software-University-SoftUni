import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0 ;
        for (int i = 0; i < n ; i++) {
            char letters = scan.nextLine().charAt(0);
            sum += letters;
        }
        System.out.println(String.format("The sum equals: %d",sum));
    }
}
