import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbersAsString = scan.nextLine().split(" ");
        int[] numbers = new int[numbersAsString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }
//        int length = 1;
//        int bestLength = 0;
//        int endIndex = -1;
//        for (int i = 0; i < numbers.length - 1; i++) {
//            if (numbers[i] == numbers[i + 1]) {
//                length++;
//                if(length > bestLength){
//                    bestLength = length;
//                    endIndex = i + 1;
//                }
//            }else{
//                length = 1;
//            }
//        }
//        for (int i = endIndex; i > endIndex - bestLength ; i--) {
//            System.out.print(numbers[i] + " ");
//        }
        int length = 1;
        int bestLength = 0;
        int endIndex = -1;
        for (int j = 0; j < numbers.length - 1; j++) {
            if (numbers[j] == numbers[j + 1]) {
                length++;
                if (length > bestLength) {
                    bestLength = length;
                    endIndex = j + 1;
                }
            } else {
                length = 1;
            }
        }
        for (int i = endIndex; i > endIndex - bestLength; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
