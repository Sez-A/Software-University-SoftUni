import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());
        String[] children = input.split("\\s+");

        Deque<String> kids = new ArrayDeque<>(Arrays.asList(children));


        int cnt = 1;
        while (kids.size() > 1) {
            String currentKid = kids.poll();
            if ( cnt % n != 0){
                kids.offer(currentKid);
            } else{
                System.out.println(String.format("Removed %s", currentKid));
            }
            cnt++;
        }

        System.out.println(String.format("Last is %s", kids.peek()));
    }
}
