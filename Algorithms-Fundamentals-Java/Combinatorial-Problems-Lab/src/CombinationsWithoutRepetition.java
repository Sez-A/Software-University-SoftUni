import java.util.Scanner;

public class CombinationsWithoutRepetition {
    public static String[] elements;
    public static String[] combinations;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        elements = scan.nextLine().split("\\s+");
        int k = Integer.parseInt(scan.nextLine());
        combinations = new String[k];
        combination(0, 0);
    }

    private static void combination(int index, int start) {
        if (index == combinations.length) {
            print(combinations);
            return;
        }

        for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                combination(index + 1, i + 1);
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }

}
