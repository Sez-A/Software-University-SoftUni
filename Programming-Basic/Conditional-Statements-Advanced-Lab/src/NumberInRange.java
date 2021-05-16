import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());

        if(number >= -100 && number != 0 && number <= 100) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
