package practical_exam_23_10_2021;

import java.util.Scanner;

public class MouseAndCheese {
    private static int mouseRow = -1;
    private static int mouseCol = -1;
    private static int cheeseEatenCnt = 0;
    private static boolean outOfTerritory = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] territory = new String[size][size];

        for (int i = 0; i < size; i++) {
            territory[i] = scan.nextLine().split("");
        }

        indexing(territory);

        String command = scan.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    moveUp(territory);
                    break;
                case "down":
                    moveDown(territory);
                    break;
                case "right":
                    moveRight(territory);
                    break;
                case "left":
                    moveLeft(territory);
                    break;
            }
            if (outOfTerritory) {
                System.out.println("Where is the mouse?");
                break;
            }
            command = scan.nextLine();
        }

        if (cheeseEatenCnt < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",
                    5 - cheeseEatenCnt);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEatenCnt);
        }

        printMatrix(territory);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveLeft(String[][] territory) {
        if (mouseCol - 1 < 0) {
            territory[mouseRow][mouseCol] = "-";
            outOfTerritory = true;
            return;
        }
        territory[mouseRow][mouseCol] = "-";
        mouseCol--;
        if (territory[mouseRow][mouseCol].equals("B")) {
            territory[mouseRow][mouseCol] = "-";
            mouseCol--;
        }
        moving(territory);
    }

    private static void moveRight(String[][] territory) {
        if (mouseCol + 1 >= territory.length) {
            outOfTerritory = true;
            territory[mouseRow][mouseCol] = "-";
            return;
        }
        territory[mouseRow][mouseCol] = "-";
        mouseCol++;
        if (territory[mouseRow][mouseCol].equals("B")) {
            territory[mouseRow][mouseCol] = "-";
            mouseCol++;
        }
        moving(territory);
    }

    private static void moveDown(String[][] territory) {
        if (mouseRow + 1 >= territory.length) {
            outOfTerritory = true;
            territory[mouseRow][mouseCol] = "-";
            return;
        }
        territory[mouseRow][mouseCol] = "-";
        mouseRow++;
        if (territory[mouseRow][mouseCol].equals("B")) {
            territory[mouseRow][mouseCol] = "-";
            mouseRow++;
        }
        moving(territory);
    }


    private static void moveUp(String[][] territory) {
        if (mouseRow - 1 < 0) {
            outOfTerritory = true;
            territory[mouseRow][mouseCol] = "-";
            return;
        }
        territory[mouseRow][mouseCol] = "-";
        mouseRow--;
        if (territory[mouseRow][mouseCol].equals("B")) {
            territory[mouseRow][mouseCol] = "-";
            mouseRow--;
        }
        moving(territory);
    }

    private static void moving(String[][] territory) {
        if (territory[mouseRow][mouseCol].equals("c")) {
            territory[mouseRow][mouseCol] = "M";
            cheeseEatenCnt++;
        } else {
            territory[mouseRow][mouseCol] = "M";
        }
    }

    private static void indexing(String[][] territory) {
        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                if (territory[i][j].equals("M")) {
                    mouseRow = i;
                    mouseCol = j;
                }
            }
        }
    }
}
