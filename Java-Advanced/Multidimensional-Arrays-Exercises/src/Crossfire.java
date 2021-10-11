import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensionInfo = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensionInfo[0];
        int cols = dimensionInfo[1];

        List<List<Integer>> matrix = new ArrayList<>();
        int filler = 1;
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(filler);
                filler++;
            }
        }
        String line = scan.nextLine();
        while (!line.equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            for (int r = row - radius; r <= row + radius; r++) {
                if (isInRange(r, col, matrix) && r != row) {
                    matrix.get(r).remove(col);
                }
            }

            for (int c = col + radius; c >= col - radius; c--) {
                if (isInRange(row, c, matrix)) {
                    matrix.get(row).remove(c);
                }
            }
            matrix.removeIf(List::isEmpty);
            line = scan.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}