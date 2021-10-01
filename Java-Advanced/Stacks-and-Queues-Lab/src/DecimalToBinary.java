import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numForConvert = Integer.parseInt(scan.nextLine());

        if (numForConvert == 0) {
            System.out.println(0);
            return;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        while (numForConvert > 0) {
            int numberToStack = numForConvert % 2;
            stack.push(numberToStack);
            numForConvert = numForConvert / 2 ;
        }
        int size = stack.size();
        for (int i = 0; i < size ; i++) {
            System.out.print(stack.pop());
        }
    }
}
