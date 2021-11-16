import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int factorial = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = Integer.parseInt("" + input.charAt(i));
            int currentFactorial = 1;
            for (int j = digit; j >= 1; j--) {
                currentFactorial *=  j;
            }
            factorial += currentFactorial;
        }
        int strongNumber = Integer.parseInt(input);
        if (factorial == strongNumber ){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
