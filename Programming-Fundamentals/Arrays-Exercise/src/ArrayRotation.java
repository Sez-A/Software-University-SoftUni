import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numberAsString = scan.nextLine().split(" ");
        int rotation = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rotation % numberAsString.length; i++) {
            String temp = numberAsString[0];
            for (int j = 0; j < numberAsString.length - 1; j++) {
                numberAsString[j] = numberAsString[j + 1];
            }
          numberAsString [numberAsString.length - 1]  = temp;
        }
        System.out.println(String.join(" ",numberAsString));
    }
}
