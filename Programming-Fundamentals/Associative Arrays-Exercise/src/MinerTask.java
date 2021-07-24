import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String,Integer> resources = new LinkedHashMap<>();
        while(!"stop".equals(input)){
            int amount = Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(input,0);
            int oldCnt = resources.get(input);
            resources.put(input,oldCnt + amount);
            input = scan.nextLine();
        }

        resources
                .forEach((k,v) -> System.out.println(String.format("%s -> %d",k,v)));
    }
}
