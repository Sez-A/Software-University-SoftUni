import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Deque<String> deque = new ArrayDeque<>();
        while (!input.equals("print")) {
            if(input.equals("cancel")) {
                if(deque.isEmpty()) {
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println(String.format("Canceled %s",deque.peek()));
                    deque.removeFirst();
                }
            }else{
                deque.offer(input);
            }
            input = scan.nextLine();
        }
        for (String string : deque) {
            System.out.println(string);
        }
    }
}
