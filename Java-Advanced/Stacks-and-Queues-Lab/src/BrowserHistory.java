import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Deque<String> stack = new ArrayDeque<>();
        String output = "";
        while (!"Home".equals(input)) {
            if (input.equals("back")) {
                if (stack.size() <= 1) {
                    output = "no previous URLs";
                } else {
                    stack.pop();
                    output = stack.peek();
                    //System.out.println(stack.pop());
                }
            }else{
                stack.push(input);
                output = input;
            }
            System.out.println(output);
            input = scan.nextLine();
        }
    }
}
