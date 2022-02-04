package OOPTasks.workingWithAbstractionLab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        // Printing top half.
        System.out.print(drawRhombus(n, true));

        // Printing bottom half.
        System.out.print(drawRhombus(n, false));


    }

    public static String drawRhombus(int n, boolean topHalf) {
        StringBuilder out = new StringBuilder();
        for (int row = 1; row <= n; row++) {
            int spaceCount = topHalf ? n - row : row;
            out.append(repeatString(" ", spaceCount));
            int starsCount = topHalf ? row : n - row;
            out.append(repeatString("* ", starsCount));
            out.append(System.lineSeparator());
        }
        return out.toString();
    }

    public static String repeatString(String value, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            sb.append(value);
        }
        return sb.toString();
    }
}
