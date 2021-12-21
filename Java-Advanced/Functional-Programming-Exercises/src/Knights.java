import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Knights {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s+");
        Consumer<String> consumer = e -> System.out.println(String.format("Sir %s",e));
        Arrays.stream(line)
                .forEach(consumer);
    }
}
