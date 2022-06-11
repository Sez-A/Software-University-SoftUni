import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        System.out.println(factorial(number));
    }

    private static long factorial(int number) {
        if (number == 1) {
            return 1;
        }
        return number *= factorial(number - 1);
    }
}
