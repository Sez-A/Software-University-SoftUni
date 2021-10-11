import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] size = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int sum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currentSum = calculateSum(matrix, row, col);

                if (currentSum > sum) {
                    sum = currentSum;
                    indexRow = row;
                    indexCol = col;
                }
            }
        }
        System.out.println("Sum = " + sum);
      printSubMatrix(matrix,indexRow,indexCol);

    }

    private static void printSubMatrix(int[][] matrix, int indexRow,int indexCol) {

        for (int row = indexRow - 1; row <= indexRow + 1 ; row++) {
            for (int col = indexCol - 1; col <= indexCol + 1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateSum(int[][] matrix, int row, int col) {
        int sum = 0;

        sum += matrix[row][col];

        // Up
        sum += matrix[row - 1][col];
        //Down
        sum += matrix[row + 1][col];
        //Right
        sum += matrix[row][col + 1];
        //Left
        sum += matrix[row][col - 1];
        //UpRight
        sum += matrix[row - 1][col + 1];
        //UpLeft
        sum += matrix[row - 1][col - 1];
        //DownRight
        sum += matrix[row + 1][col + 1];
        //DownLeft
        sum += matrix[row + 1][col - 1];
        return sum;
    }
}
