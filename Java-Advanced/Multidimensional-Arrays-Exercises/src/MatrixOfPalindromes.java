import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int r = input[0];
        int c = input[1];
        String[][] matrix = new String[r][c];
        String result = "";
        for (int i = 0; i < r; i++) {
            char firstLetter = (char) (97 + i);
            char lastLetter = (char) (97 + i);
            for (int j = 0; j < c; j++) {
                char middleLetter = (char) (firstLetter + j);
                result = String.valueOf(firstLetter) + String.valueOf(middleLetter) + String.valueOf(lastLetter);
                matrix[i][j] = result;
            }

        }
        printMatrix(matrix);

    }

    public static void printMatrix(String matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ") ;
            }
            System.out.println();
        }
    }
}