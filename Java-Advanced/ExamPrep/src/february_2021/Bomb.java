package february_2021;

import java.util.Scanner;

public class Bomb {
    public static int totalBombCnt = 0;
    public static int sapperRow = -1;
    public static int sapperCol = -1;
    public static boolean endReached = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] field = new String[size][size];

        String[] commands = scan.nextLine().split(",");

        for (int i = 0; i < size; i++) {
            field[i] = scan.nextLine().split("\\s+");
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("s")) {
                    sapperRow = i;
                    sapperCol = j;
                } else if (field[i][j].equals("B")) {
                    totalBombCnt++;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "up":
                    moveUp(field);
                    break;
                case "down":
                    moveDown(field);
                    break;
                case "right":
                    moveRight(field);
                    break;
                case "left":
                    moveLeft(field);
                    break;
            }

            if (totalBombCnt <= 0 || endReached) {
                break;
            }
        }

        if (totalBombCnt <= 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (endReached) {
            System.out.println(String.format("END! %d bombs left on the field", totalBombCnt));
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n"
                    , totalBombCnt, sapperRow, sapperCol);
        }
    }

    private static void moveLeft(String[][] field) {
        if (sapperCol - 1 < 0) {
            return;
        }

        field[sapperRow][sapperCol] = "+";
        sapperCol--;

        checker(field);
    }

    private static void moveRight(String[][] field) {
        if (sapperCol + 1 >= field.length) {
            return;
        }

        field[sapperRow][sapperCol] = "+";
        sapperCol++;

        checker(field);
    }

    private static void moveDown(String[][] field) {
        if (sapperRow + 1 >= field.length) {
            return;
        }

        field[sapperRow][sapperCol] = "+";
        sapperRow++;

        checker(field);
    }


    private static void moveUp(String[][] field) {
        if (sapperRow - 1 < 0) {
            return;
        }

        field[sapperRow][sapperCol] = "+";
        sapperRow--;

        checker(field);
    }


    private static void checker(String[][] field) {
        if (field[sapperRow][sapperCol].equals("B")) {
            System.out.println("You found a bomb!");
            totalBombCnt--;
            field[sapperRow][sapperCol] = "+";

        } else if (field[sapperRow][sapperCol].equals("e")) {
            endReached = true;

        } else {
            field[sapperRow][sapperCol] = "s";
        }
    }
}
