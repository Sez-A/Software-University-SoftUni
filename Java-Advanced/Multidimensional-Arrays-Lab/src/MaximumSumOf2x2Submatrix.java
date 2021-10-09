import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static int firstRow = 0;
    public static int firstCol = 0;
    public static int secondRow = 1;
    public static int secondCol = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndColsInfo = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndColsInfo[0];
        int cols = rowsAndColsInfo[1];


        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = row;
        }
        boolean isValid = (secondRow <= matrix.length - 1) && (secondCol <= matrix.length - 1);

//        boolean outOfRange = firstRow < 0 || firstRow >= matrix.length || firstCol < 0
//                || firstCol >= matrix.length || secondRow < 0 || secondRow > matrix.length
//                || secondCol > matrix.length || secondCol < 0;

        int subMatFirstRow = -1;
        int subMatFirstCol = -1;
        int subMatSecondRow = -1;
        int subMatSecondCol = -1;
        int subMatThirdRow = -1;
        int subMatThirdCol = -1;
        int subMatFourthRow = -1;
        int subMatFourthCol = -1;

        int maxSum = Integer.MIN_VALUE;
        while (isValid) {
            int currentSum = 0;
            if (secondRow == matrix.length) {
                isValid = false;
            } else {
                for (int i = 0; i < cols; i++) {
                    for (int j = 0; j < 2; j++) {
                        currentSum += matrix[firstRow][firstCol];
                        currentSum += matrix[secondRow][secondCol];
                        firstCol++;
                        secondCol++;
                    }

                    firstCol--;
                    secondCol--;
                    if (currentSum > maxSum) {
                        maxSum = currentSum;
                        subMatFirstRow = firstRow ;
                        subMatFirstCol = firstCol - 1;
                        subMatSecondRow = secondRow;
                        subMatSecondCol = secondCol - 1;
                        subMatThirdRow = firstRow;
                        subMatThirdCol = firstCol;
                        subMatFourthRow = secondRow;
                        subMatFourthCol = secondCol;
                    }
                    currentSum = 0;
                    if (firstCol + 1 >= matrix[0].length)
                        break;
                }
                firstRow++;
                firstCol = 0;
                secondRow++;
                secondCol = 0;
            }

        }

        System.out.print(matrix[subMatFirstRow][subMatFirstCol] + " ");
        System.out.print(matrix[subMatThirdRow][subMatThirdCol] );
        System.out.println();
        System.out.print(matrix[subMatSecondRow][subMatSecondCol] + " " );
        System.out.print(matrix[subMatFourthRow][subMatFourthCol] );
        System.out.println();
        System.out.println(maxSum);
    }
}
