import java.util.Scanner;

public class EqualSumsEvenOddPositions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = Integer.parseInt(scan.nextLine());
        int secondNum = Integer.parseInt(scan.nextLine());

        for (int i = firstNum; i <= secondNum; i++) {
            int evenPSum = 0;
            int oddPSum = 0;
            int currentNum = i;
            int index = 1;
            while (currentNum != 0) {
                if (index % 2 == 0) {
                    evenPSum += (currentNum % 10);
                } else {
                    oddPSum += (currentNum % 10);
                }
                currentNum /= 10;
                index++;
            }
            if (evenPSum == oddPSum)
                System.out.print(i + " ") ;
        }
    }
}
