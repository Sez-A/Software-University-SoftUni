package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndColsValues = readIntArr(scanner);
        int rows = rowsAndColsValues[0];
        int cols = rowsAndColsValues[1];

        WarField field = new WarField(rows, cols);

        field.fillField();

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoCoordinates = intArrByString(command);
            int[] enemyCoordinates = readIntArr(scanner);

            int startRowEnemy = enemyCoordinates[0];
            int startColEnemy = enemyCoordinates[1];


            Enemy enemy = new Enemy(startRowEnemy, startColEnemy);

            int startRowHero = ivoCoordinates[0];
            int startColHero = ivoCoordinates[1];
            Hero hero = new Hero(startRowHero, startColHero);

            field.fight(hero, enemy);
            sum += hero.getPoints();
            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static int[] readIntArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[] intArrByString(String string) {
        String[] tokens = string.split("\\s+");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        return arr;
    }

}
