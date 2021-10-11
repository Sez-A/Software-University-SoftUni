import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        String line = "";
        while (!(line = scan.nextLine()).equals("END")) {
            String[] tokens = line.split("\\s+");
            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            if (!tokens[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            if (row1 < 0 || row1 > rows || col1 < 0 || col1 > cols
                    || row2 < 0 || row2 > rows || col2 < 0 || col2 > cols) {
                System.out.println("Invalid input!");
                continue;
            }
            String temp = "";
            temp = matrix[row2][col2];
            matrix[row2][col2] = matrix[row1][col1];
            matrix[row1][col1] = temp;
            printMatrix(matrix);
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}