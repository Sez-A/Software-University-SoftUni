import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDiff {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = input;

        }
        int sum = 0;
        int cnt = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][cnt];
            cnt++;
        }
        int sum2 = 0;
        int cnt1 = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            sum2 += matrix[row][cnt1];
            cnt1++;
        }
        System.out.println(Math.abs(sum - sum2));
    }
}
