import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = readCharMatrix(rows, cols, scan);


        char[][] secondMatrix = readCharMatrix(rows, cols, scan);

        char[][] finalMatrix = new char[rows][cols];
        for (int row = 0; row < firstMatrix.length; row++) {
            char[] firstArr = firstMatrix[row];
            char[] secondArr = secondMatrix[row];
            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] == secondArr[col]) {
                    finalMatrix[row][col] = firstArr[col];
                }else{
                    char symbolToAdd = '*';
                    finalMatrix[row][col] = symbolToAdd;
                }
            }
        }
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readCharMatrix(int rows, int cols, Scanner scan) {
        char[][] matrixToReturn = new char[rows][];
        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split("\\s+");
            char[] symbols = new char[input.length];
            for (int j = 0; j < input.length; j++) {
                symbols[j] = input[j].charAt(0);
            }
            matrixToReturn[i] = symbols;
        }
        return matrixToReturn;
    }
}
