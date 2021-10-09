import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(java.lang.System.in);
        int[] rowsAndCols = readIntArr(scan);
        int rowsForFirstMatrix = rowsAndCols[0];
        int colsForFirstMatrix = rowsAndCols[1];

        int[][] firstMatrix = readIntMatrix(rowsForFirstMatrix, colsForFirstMatrix, scan);

        rowsAndCols = readIntArr(scan);
        int rowsForSecondMatrix = rowsAndCols[0];
        int colsForSecondMatrix = rowsAndCols[0];
        int[][] secondMatrix = readIntMatrix(rowsForSecondMatrix, colsForSecondMatrix, scan);

        if(compareIntMatrices(firstMatrix,secondMatrix)) {
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    private static boolean compareIntMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length ; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if(firstArr.length != secondArr.length) {
                return false;
            }
            for (int i = 0; i < firstArr.length ; i++) {
                if(firstArr[i] != secondArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readIntMatrix(int rows, int cols, Scanner scan) {
        int[][] matrixToReturn = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] currentArr = readIntArr(scan);
            for (int col = 0; col < cols; col++) {
                matrixToReturn[row] = currentArr;
            }
        }
        return matrixToReturn;
    }


    private static int[] readIntArr(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
