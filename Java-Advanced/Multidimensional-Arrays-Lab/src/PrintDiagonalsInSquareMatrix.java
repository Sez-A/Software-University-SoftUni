import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsInSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = intArrReader(scan);
        }

        int rows = 0;
        int cols = 0;

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[rows][cols] + " ");
            rows++;
            cols++;
        }
        System.out.println();
        rows = matrix.length - 1;
        cols = 0;
        for (int i = 0; i < matrix.length ; i++) {
            System.out.print(matrix[rows][cols] + " ");
            rows -- ;
            cols++;
        }
    }

    private static int[] intArrReader(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(n -> Integer.parseInt(n))
                .toArray();
    }

}
