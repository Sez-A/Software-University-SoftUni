package midexam02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "swap": {
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    int fTemp = 0;
                    int sTemp = 0;
                    for (int i = 0; i < array.length; i++) {

                        if (i == firstIndex) {
                            fTemp = array[i];
                        }

                        if (i == secondIndex) {
                            sTemp = array[i];
                        }
                    }

                    for (int i = 0; i < array.length; i++) {
                        if (i == firstIndex) {
                            array[i] = sTemp;
                        }

                        if (i == secondIndex) {
                            array[i] = fTemp;
                        }
                    }
                }
                break;

                case "multiply": {
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);

                    int product = 1;

                    for (int i = 0; i < array.length; i++) {
                        if (i == firstIndex) {
                            product *= array[i];
                        }

                        if (i == secondIndex) {
                            product *= array[i];
                        }
                    }

                    for (int i = 0; i < array.length; i++) {
                        if (i == firstIndex) {
                            array[i] = product;
                        }
                    }
                }
                break;

                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i] -= 1;
                    }
                    break;
            }
            command = scan.nextLine();
        }

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }
}
