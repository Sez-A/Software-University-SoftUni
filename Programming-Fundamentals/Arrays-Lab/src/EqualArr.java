import java.util.Scanner;

public class EqualArr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstArr = scan.nextLine().split(" ");
        String[] secondArr = scan.nextLine().split(" ");
        int[] firstArrInt = new int[firstArr.length];
        int[] secondArrInt = new int[firstArr.length];
        int cnt = 0;
        boolean flagT = false;
        int sum = 0;
        for (int i = 0; i < firstArrInt.length; i++) {
            firstArrInt[i] = Integer.parseInt(firstArr[i]);
            secondArrInt[i] = Integer.parseInt(secondArr[i]);
            if (firstArrInt[i] == secondArrInt[i]) {
                sum += firstArrInt[i];
                cnt++;
                flagT = true;
            } else {
                 System.out.printf("Arrays are not identical. Found difference at %d index.",cnt);
                flagT = false;
                break;
            }
        }
        if (flagT) {
            System.out.println(String.format("Arrays are identical. Sum: %d", sum));
        }
    }
}
