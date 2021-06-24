import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbersAsString = scan.nextLine().split(" ");
        int[] numbers = new int[numbersAsString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int temp = numbers[i];
            boolean isTrue = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (temp <= numbers[j]) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                System.out.print(temp + " ");
            }
        }
        System.out.println(numbers[numbers.length - 1]);
    }
}