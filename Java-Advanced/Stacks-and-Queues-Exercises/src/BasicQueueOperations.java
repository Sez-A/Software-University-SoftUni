import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input[] = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(n -> Integer.parseInt(n))
                .toArray();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int numbersToDelete = input[1];
        int target = input[2];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int number : numbers) {
            queue.offer(number);
        }

        for (int i = 0; i < numbersToDelete ; i++) {
            queue.poll();
        }

        if(queue.contains(target)){
            System.out.println("true");
        }else if (queue.isEmpty()) {
            System.out.println(0);
        }else{
            System.out.println(Collections.min(queue));
        }
    }
}
