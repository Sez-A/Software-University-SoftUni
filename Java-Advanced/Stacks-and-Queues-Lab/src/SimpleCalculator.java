import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = readInput(scan);
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = input.split("\\s+");

        stack.push(Integer.parseInt(tokens[0]));

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int num = Integer.parseInt(tokens[i + 1]);
                stack.push(num + stack.pop());
            } else if (tokens[i].equals( "-")) {
                int num = Integer.parseInt(tokens[i + 1]);
                stack.push(stack.pop() - num);
            }
        }
        System.out.println(stack.peek());
    }

    private static String readInput(Scanner scan) {
        return scan.nextLine();
    }
}
