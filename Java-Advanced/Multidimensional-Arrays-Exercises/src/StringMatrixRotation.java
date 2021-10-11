import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rotationIn = scan.nextLine();
        String sub = rotationIn.substring(rotationIn.indexOf('(') + 1
                , rotationIn.lastIndexOf(')'));

        int rotationDegrees = Integer.parseInt(sub);

        while (rotationDegrees >= 360) {
            rotationDegrees = rotationDegrees - 360;
        }

        List<String> texts = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;
        String input = scan.nextLine();
        while (!input.equals("END")) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            texts.add(input);
            input = scan.nextLine();
        }

        char[][] matrix = new char[texts.size()][maxLength];


        for (int i = 0; i < matrix.length; i++) {
            String str = texts.get(i);
            for (int j = 0; j < maxLength; j++) {
                try {
                    matrix[i][j] = str.charAt(j);
                } catch (IndexOutOfBoundsException e) {
                    matrix[i][j] = ' ';
                }
            }
        }


        switch (rotationDegrees) {
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                rotateMatrixTo90Degrees(maxLength, matrix);
                break;
            case 180:
                rotateMatrix180Degrees(maxLength, matrix);
                break;
            case 270:
                rotateMatrix270Degrees(maxLength, matrix);
                break;
        }

    }

    private static void rotateMatrix270Degrees(int maxLength, char[][] matrix) {
        for (int cols = maxLength - 1; cols >= 0; cols--) {
            for (int rows = 0; rows < matrix.length; rows++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void rotateMatrix180Degrees(int maxLength, char[][] matrix) {
        for (int rows = matrix.length - 1; rows >= 0; rows--) {
            for (int cols = maxLength - 1; cols >= 0; cols--) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void rotateMatrixTo90Degrees(int maxLength, char[][] matrix) {
        for (int cols = 0; cols < maxLength; cols++) {
            for (int rows = matrix.length - 1; rows >= 0; rows--) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
