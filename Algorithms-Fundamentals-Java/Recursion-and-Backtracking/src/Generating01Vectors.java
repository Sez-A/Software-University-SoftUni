import java.util.Scanner;

public class Generating01Vectors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Integer[] arr = new Integer[n];
        fillArray(arr, 0);
    }

    public static void fillArray(Integer[] array, int index) {
        if (index >= array.length) {
            print(array);
            return;
        }

        for (int j = 0; j <= 1; j++) {
            array[index] = j;
            fillArray(array, index + 1);
        }

    }

    private static void print(Integer[] array) {
        for (Integer integer : array) {
            System.out.print(integer);
        }
        System.out.println();
    }
}
