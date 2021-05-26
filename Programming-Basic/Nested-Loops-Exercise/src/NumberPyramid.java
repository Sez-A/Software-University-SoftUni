import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());


        int cnt = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (cnt > n)
                    return;
                System.out.print(cnt++ + " ");
            }
            System.out.println();
        }

    }
}
