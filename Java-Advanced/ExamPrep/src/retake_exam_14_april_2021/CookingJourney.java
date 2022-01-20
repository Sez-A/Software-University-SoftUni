package retake_exam_14_april_2021;

import java.util.Scanner;

public class CookingJourney {
    private static int playerRow = -1;
    private static int playerCol = -1;
    private static double currentMoney = 0;
    private static int f_pillarRow = -1;
    private static int f_pillarCol = -1;
    private static int s_pillarRow = -1;
    private static int s_pillarCol = -1;
    private static boolean outOfPastryShop = false;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] shop = new String[size][size];

        for (int i = 0; i < size; i++) {
            shop[i] = scan.nextLine().split("");
        }

        indexing(shop);

        while (true) {
            switch (scan.nextLine()) {
                case "up":
                    moveUp(shop);
                    break;
                case "down":
                    moveDown(shop);
                    break;
                case "right":
                    moveRight(shop);
                    break;
                case "left":
                    moveLeft(shop);
                    break;
            }
            if (outOfPastryShop) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            } else if (currentMoney >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }

        printOutput(shop);

    }

    private static void printOutput(String[][] shop) {
        System.out.printf("Money: %.0f%n", currentMoney);
        printMatrix(shop);

    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveLeft(String[][] shop) {
        if (playerCol - 1 < 0) {
            outOfField(shop);
            return;
        }
        shop[playerRow][playerCol] = "-";
        playerCol--;
        moving(shop);
    }


    private static void moveRight(String[][] shop) {
        if (playerCol + 1 >= shop.length) {
            outOfField(shop);
            return;
        }
        shop[playerRow][playerCol] = "-";
        playerCol++;
        moving(shop);
    }


    private static void moveUp(String[][] shop) {
        if (playerRow - 1 < 0) {
            outOfField(shop);
            return;
        }

        shop[playerRow][playerCol] = "-";
        playerRow--;
        moving(shop);
    }

    private static void moveDown(String[][] shop) {
        if (playerRow + 1 >= shop.length) {
            outOfField(shop);
            return;
        }
        shop[playerRow][playerCol] = "-";
        playerRow++;
        moving(shop);
    }

    private static void outOfField(String[][] shop) {
        shop[playerRow][playerCol] = "-";
        outOfPastryShop = true;
        return;
    }

    private static void moving(String[][] shop) {
        if (shop[playerRow][playerCol].equals("P")) {
            shop[playerRow][playerCol] = "-";
            shop[s_pillarRow][s_pillarCol] = "S";
            playerRow = s_pillarRow;
            playerCol = s_pillarCol;
        } else if (Character.isDigit(shop[playerRow][playerCol].charAt(0))) {
            currentMoney += Double.parseDouble(shop[playerRow][playerCol]);
            if (currentMoney >= 50) {
                shop[playerRow][playerCol] = "S";
            } else {
                shop[playerRow][playerCol] = "-";
            }
        }
    }

    private static void indexing(String[][] shop) {
        int pillarCount = 0;
        for (int i = 0; i < shop.length; i++) {
            for (int j = 0; j < shop[i].length; j++) {
                if (shop[i][j].equals("S")) {
                    playerRow = i;
                    playerCol = j;
                } else if (shop[i][j].equals("P") && pillarCount == 0) {
                    f_pillarRow = i;
                    f_pillarCol = j;
                    pillarCount++;
                } else if (shop[i][j].equals("P") && pillarCount > 0) {
                    s_pillarRow = i;
                    s_pillarCol = j;
                }
            }
        }
    }
}
