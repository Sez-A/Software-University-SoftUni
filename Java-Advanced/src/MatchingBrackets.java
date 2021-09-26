import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length() ; i++) {
            char[] chars = input.toCharArray();
            if(chars[i] == '('){
                stack.push(i);
            }else if (chars[i] == ')') {
                int startIndex = stack.pop();
                String output = input.substring(startIndex, i + 1);
                System.out.println(output);
            }
        }
    }
}
