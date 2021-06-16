import java.util.Scanner;

public class RefactorSpecialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int currentNumber = i;
            while (currentNumber > 0) {
                int digit = currentNumber % 10;
                sum += digit;
                currentNumber = currentNumber / 10;
            }
            if((sum == 5) || (sum == 7) || (sum == 11)){
                System.out.println(String.format("%d -> True",i));
            }else{
                System.out.println(String.format("%d -> False",i));
            }
        }
    }
}
