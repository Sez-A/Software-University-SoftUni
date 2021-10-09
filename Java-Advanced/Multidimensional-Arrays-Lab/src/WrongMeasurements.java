import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = row;
        }
        int[][] helperMatrix = new int[rows][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                helperMatrix[i][j] = matrix[i][j];
            }
        }

        int[] wrongNumInfo = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongNumRow = wrongNumInfo[0];
        int wrongNumCol = wrongNumInfo[1];

        int wrongNum = matrix[wrongNumRow][wrongNumCol];


        for (int i = 0; i < helperMatrix.length; i++) {
            int replacementSum = 0;
            for (int j = 0; j < helperMatrix[i].length; j++) {
                int currentValue = matrix[i][j];
                if (currentValue == wrongNum) {
                    replacementSum += moveLeft(wrongNum, matrix, i, j);
                    replacementSum += moveRight(wrongNum, matrix, i, j);
                    replacementSum += moveDown(wrongNum, matrix, i, j);
                    replacementSum += moveUp(wrongNum, matrix, i, j);
                    helperMatrix[i][j] = replacementSum;
                    replacementSum = 0;
                }
            }
        }
        printMatrix(helperMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int moveUp(int wrongNum, int[][] matrix, int row, int col) {
        if (!(row - 1 < 0)) {
            if ((matrix[row - 1][col] != wrongNum)) {
                return matrix[row - 1][col];
            }
        }
        return 0;
    }

    private static int moveDown(int wrongNum, int[][] matrix, int row, int col) {
        if ((row + 1 < matrix.length)) {
            if ((matrix[row + 1][col] != wrongNum)) {
                return matrix[row + 1][col];
            }
        }
        return 0;
    }

    private static int moveRight(int wrongNum, int[][] matrix, int row, int col) {
        if ((col + 1 < matrix[0].length)) {
            if ((matrix[row][col + 1] != wrongNum)) {
                return matrix[row][col + 1];
            }
        }
        return 0;
    }

    private static int moveLeft(int wrongNum, int[][] matrix, int row, int col) {

        if (!(col - 1 < 0)) {
            if ((matrix[row][col - 1] != wrongNum)) {
                return  matrix[row][col - 1];

            }
        }
        return 0;
    }
}