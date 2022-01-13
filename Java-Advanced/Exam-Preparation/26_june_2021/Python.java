package exam_26_june_2021;

import java.util.Scanner;

public class Python {
    private static int pythonRow = -1;
    private static int pythonCol = -1;
    private static int pythonLength = 1;
    private static int foodCount = 0;

    private static boolean killedByEnemy = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(", ");
        String[][] screen = new String[size][size];
        for (int i = 0; i < size; i++) {
            screen[i] = scan.nextLine().split(" ");
        }

        introducingInGame(screen);
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "up":
                    moveUp(screen);
                    break;
                case "down":
                    moveDown(screen);
                    break;
                case "right":
                    moveRight(screen);
                    break;
                case "left":
                    moveLeft(screen);
                    break;
            }
            if (killedByEnemy) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (foodCount <= 0) {
                System.out.printf("You win! Final python length is %d%n", pythonLength);

                return;
            }
        }


        System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);

    }

    private static void moveLeft(String[][] screen) {
        if (pythonCol - 1 < 0) {
            pythonCol = screen.length;
        }
        pythonCol--;
        pythonMoving(screen);
    }

    private static void moveRight(String[][] screen) {
        if (pythonCol + 1 >= screen.length) {
            pythonCol = -1;
        }
        pythonCol++;
        pythonMoving(screen);
    }

    private static void moveDown(String[][] screen) {
        if (pythonRow + 1 >= screen.length) {
            pythonRow = -1;
        }
        pythonRow++;
        pythonMoving(screen);
    }

    private static void moveUp(String[][] screen) {
        if (pythonRow - 1 < 0) {
            pythonRow = screen.length;
        }

        pythonRow--;
        pythonMoving(screen);

    }

    private static void pythonMoving(String[][] screen) {
        if (screen[pythonRow][pythonCol].equals("e")) {
            killedByEnemy = true;
            return;
        } else if (screen[pythonRow][pythonCol].equals("f")) {
            screen[pythonRow][pythonCol] = "*";
            foodCount--;
            pythonLength++;
        }
    }

    private static void introducingInGame(String[][] screen) {
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                if (screen[i][j].equals("s")) {
                    pythonRow = i;
                    pythonCol = j;
                } else if (screen[i][j].equals("f")) {
                    foodCount++;
                }
            }
        }
    }
}
