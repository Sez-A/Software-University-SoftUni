import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Deque<String> backURLs = new ArrayDeque<>();
        Deque<String> forwardURLs = new ArrayDeque<>();
        String output = "";
        while (!"Home".equals(input)) {
            if (input.equals("back")) {
                if (backURLs.size() <= 1) {
                    output = "no previous URLs";
                } else {
                    String pop = backURLs.pop();

                    output = backURLs.peek();
                    forwardURLs.addFirst(pop);
                }

            } else if (input.equals("forward")) {
                if (forwardURLs.size() < 1) {
                    output = "no next URLs";
                } else {
                    String pop = forwardURLs.poll();

                    output = pop;
                    backURLs.push(pop);
                }
            } else {
                backURLs.push(input);
                output = input;
                forwardURLs.clear();
            }
            System.out.println(output);
            input = scan.nextLine();
        }
    }
}