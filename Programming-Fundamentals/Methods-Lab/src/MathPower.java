import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {

    public static double numberPow (double num , int pow){
        double result = 1;
        result = Math.pow(num,pow);
        return result ;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double number = Double.parseDouble(scan.nextLine());
        int pow = Integer.parseInt(scan.nextLine());

        System.out.println(new DecimalFormat("0.####").format(numberPow(number,pow)));
    }
}
