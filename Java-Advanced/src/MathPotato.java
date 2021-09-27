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
                String currentChild = kids.poll();
                kids.offer(currentChild);
            }
            if (isPrime(cycles)) {
                String kid = kids.peek();
                System.out.println(String.format("Prime %s", kid));

            } else {
                String kid = kids.poll();
                System.out.println(String.format("Removed %s", kid));
            }
            cycles++;
        }
        String name = kids.peek();
        System.out.println("Last is " + name);
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        if(number > 2 && number % 2 == 0) {
            return false;
        }else if (number > 3 && number % 3 == 0) {
            return false;
        }else if (number > 5 && number % 5 == 0) {
            return false;
        }else if (number > 7 && number % 7 == 0) {
            return false;
        }

        return true;
    }
}
