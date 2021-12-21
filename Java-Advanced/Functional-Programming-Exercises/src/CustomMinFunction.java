import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int[] arr = Arrays.stream(bf.readLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();

        System.out.println(Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt());
//        System.out.println(Arrays.stream(arr)
//                .min()
//                .getAsInt());
    }
}
