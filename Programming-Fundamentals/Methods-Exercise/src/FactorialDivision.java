import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scan.nextLine());
        double secondNumber = Double.parseDouble(scan.nextLine());
        double result = factorialDivision(firstNumber, secondNumber);
        System.out.println(String.format("%.2f", result));
    }

    public static double factorialDivision(double first, double second) {
        double firstFactorial = factorialFinder(first);
        double secondFactorial = factorialFinder(second);

        double result = firstFactorial / secondFactorial;
        return result;
    }

    public static double factorialFinder(double number) {
        double factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
