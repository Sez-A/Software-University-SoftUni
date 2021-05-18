import java.util.Scanner;

public class OperationBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        String evenOrOdd = "";
        double result = 0;

        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "/":
                if (secondNum == 0) {
                    System.out.printf("Cannot divide %d by zero", firstNum);
                    return ;
                }
                result = firstNum / (secondNum * 1.0);
                break;
            case "%":
                if (secondNum == 0) {
                    System.out.printf("Cannot divide %d by zero", firstNum);
                    return ;
                }
                result = firstNum % secondNum;
                break;
        }
        if (operator.equals("+") || operator.equals("*") || operator.equals("-")) {
            if (result % 2 == 0) {
                evenOrOdd = "even";

            } else {
                evenOrOdd = "odd";

            }
            System.out.printf("%d %s %d = %.0f - %s", firstNum, operator, secondNum, result, evenOrOdd);
        } else if (operator.equals("/")) {
            System.out.printf("%d / %d = %.2f", firstNum, secondNum, result);
        } else if (operator.equals("%")) {
            System.out.printf("%d %% %d = %.0f", firstNum, secondNum, result);
        }
        if (secondNum == 0) {
            System.out.printf("Cannot divide %d by zero", firstNum);
        }
    }
}
