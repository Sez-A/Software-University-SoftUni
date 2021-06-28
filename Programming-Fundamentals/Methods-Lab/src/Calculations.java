import java.util.Scanner;

public class Calculations {

    public static void add(int numOne, int numTwo) {
        System.out.println(numOne + numTwo);
    }

    public static void subtract(int numOne, int numTwo) {
        System.out.println(numOne - numTwo);
    }

    public static void divide(int numOne, int numTwo) {
        System.out.println(numOne / numTwo);
    }

    public static void multiply(int numOne, int numTwo) {
        System.out.println(numOne * numTwo);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        switch (command) {
            case "add":
                add(firstNum, secondNum);
                break;
            case "subtract":
                subtract(firstNum, secondNum);
                break;
            case "multiply":
                multiply(firstNum, secondNum);
                break;
            case "divide":
                divide(firstNum, secondNum);
                break;

        }
    }
}
