import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] size = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] currentArr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = currentArr;
        }
        int target = Integer.parseInt(scan.nextLine());
        boolean isFind = false;
        for (int row = 0; row < matrix.length; row++) {
            int[] arrToCompare = matrix[row];
            for (int col = 0; col < arrToCompare.length; col++) {
                if (arrToCompare[col] == target){
                    isFind = true;
                    System.out.println(row + " " + col);

                }
            }
        }
        if(!isFind) {
            System.out.println("not found");
        }
    }
}
