import java.util.Scanner;

public class ZigZagArr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] firstArr = new String[n];
        String[] secondArr = new String[n];

        for (int i = 0; i < n; i++) {
            String[] currentLine = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                firstArr[i] = currentLine[0];
                secondArr[i] = currentLine[1];
            }else{
                firstArr [i] = currentLine[1];
                secondArr [i] = currentLine[0];
            }
        }
        System.out.println(String.join(" ",firstArr));
        System.out.println(String.join(" ",secondArr));
    }
}
//        int rotation = Integer.parseInt(scan.nextLine());
//
////        int[]numbers = new int[numbersAsString.length];
////        for (int i = 0; i < numbers.length ; i++) {
////            numbers[i] = Integer.parseInt(numbersAsString[i]);
////        }
//
//        for (int i = 0; i < rotation % numbersAsString.length; i++) {
//            String temp = numbersAsString[0];
//            for (int j = 0; j < numbersAsString.length - 1; j++) {
//                numbersAsString[i] = numbersAsString[i + 1];
//            }
//        }
