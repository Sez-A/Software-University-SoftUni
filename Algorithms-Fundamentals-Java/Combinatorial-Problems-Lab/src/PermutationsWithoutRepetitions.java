import java.util.Scanner;

public class PermutationsWithoutRepetitions {
    public static String[] elements;
    public static String[] permutations;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        elements = scan.nextLine().split("\\s+");
        permutations = new String[elements.length];
        used = new boolean[elements.length];
        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(permutations);
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutations[index] = elements[i];
                permute(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
