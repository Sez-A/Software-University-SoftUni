import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Deque<Character> stack = new ArrayDeque<>();

        String table = "([{";
        boolean balanced = true;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (table.contains(symbol + "")) {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                char top = stack.pop();
                if (!(top == '(' && symbol == ')'
                        || top == '[' && symbol == ']'
                        || top == '{' && symbol == '}')) {
                    balanced = false;
                }
            }
        }
        String output = balanced ? "YES" : "NO";
        System.out.println(output);
    }
}
