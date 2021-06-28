import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //    / * + -
        double firstNumber = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        double secondNumber = Integer.parseInt(scan.nextLine());

        calculate(firstNumber, operator, secondNumber);
        System.out.println(new DecimalFormat("0.####").format(calculate(firstNumber,operator,secondNumber)));
    }

    public static double calculate(double firstNum, String operator, double secondNum) {
        double result = 0.0;
        switch (operator) {
            case "/":
                result = firstNum / secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
        }
        return result;
    }
}
