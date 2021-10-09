import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimension = intArrReader(scan);

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows ; row++) {

            matrix[row] = intArrReader(scan);
        }
        int sum = 0;
        for (int[] numbers : matrix) {
            for (int number : numbers) {
                sum+= number;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int[] intArrReader(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).
                mapToInt(n->Integer.parseInt(n))
                .toArray();
    }
}
