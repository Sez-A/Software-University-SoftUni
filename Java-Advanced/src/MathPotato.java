import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());
        String[] children = input.split("\\s+");

        Deque<String> kids = new ArrayDeque<>(Arrays.asList(children));

        int cycles = 1;
        while (kids.size() > 1) {
            for (int i = 1; i < n; i++) {
                String child = kids.remove();
                kids.offer(child);
            }
            String name = kids.peek();
            if (!isPrime(cycles)) {
                System.out.println(String.format("Removed %s", name));
                kids.remove();
            } else {
                System.out.println(String.format("Prime %s", name));
            }
            cycles++;
        }
        String name = kids.peek();
        System.out.println("Last is " + name);
    }

    private static boolean isPrime(int number) {
        if(number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
