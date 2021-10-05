import java.util.*;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] numbersToStack = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int numberToRemove = input[1];
        int target = input[2];
        Deque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbers.push(numbersToStack[i]);
        }

        for (int i = 0; i < numberToRemove ; i++) {
            numbers.pop();
        }
        if(numbers.contains(target)) {
            System.out.println("true");
        }else if (numbers.isEmpty()) {
            System.out.println(0);
        }else{
            System.out.println(Collections.min(numbers));
        }
    }
}
