import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] train = new int[n];
        int sum = 0;
        for (int i = 0; i < train.length; i++) {
            int wagon = Integer.parseInt(scan.nextLine());
            train[i] = wagon;
            sum += train[i];
            System.out.print(train[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
