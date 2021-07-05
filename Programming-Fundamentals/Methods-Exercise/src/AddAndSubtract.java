import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        int sum = addMethod(a, b) - subtractMethod(c);
        System.out.println(sum);
    }

    public static int addMethod (int firstNum, int secondNum){
        int sum = firstNum + secondNum;
        return sum;
    }
    public static  int subtractMethod (int number){
        return number;
    }
}
