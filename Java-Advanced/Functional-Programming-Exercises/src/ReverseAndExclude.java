import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int target = Integer.parseInt(bf.readLine());

        arr = arr.stream()
                .filter(e -> e % target != 0)
                .collect(Collectors.toList());

        Collections.reverse(arr);
        arr.forEach(e -> System.out.print(e + " "));


    }
}
