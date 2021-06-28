import java.util.Scanner;

public class SignOfInteger {


    public static void signOfInteger(int num){
        if(num > 0 ){
            System.out.println(String.format("The number %d is positive.",num));
        }else if(num < 0 ){
            System.out.printf("The number %d is negative.",num);
        }else {
            System.out.println("The number 0 is zero.");
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        signOfInteger(number);
    }
}
