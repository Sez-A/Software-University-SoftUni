package midexam03retake;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int shotCnt = 0;
        String line = scan.nextLine();
        while (!line.equals("End")) {
            int index = Integer.parseInt(line);

            int currentValue = 0;
            if (validIndex(index, arr)) {
                for (int i = 0; i < arr.length; i++) {
                    if (i == index) {
                        currentValue = arr[i];
                        arr[i] = -1;
                        shotCnt++;

                        for (int j = 0; j < arr.length; j++) {
                            if (arr[j] <= currentValue && arr[j] != -1) {
                                arr[j] += currentValue;
                            } else if (arr[j] > currentValue && arr[j] != -1) {
                                arr[j] -= currentValue;
                            }
                        }
                    }
                }
            }

            line = scan.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shotCnt);
        for (int target : arr) {
            System.out.print(target + " ");
        }
    }

    private static boolean validIndex(int index, int[] arr) {

        if (index >= 0 && index < arr.length) {
            return true;
        }
        return false;
    }
}
