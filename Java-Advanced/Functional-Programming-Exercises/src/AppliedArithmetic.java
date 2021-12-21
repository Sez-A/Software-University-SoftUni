import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = "";

        Function<List<Integer>, List<Integer>> add = l -> l.stream()
                .map(e -> e + 1).collect(Collectors.toList());


        while (!(line = bf.readLine()).equals("end")) {
            switch (line) {
                case "add":
                    list = add.apply(list);
                    break;

                case "multiply":
                    list = list.stream()
                            .map(e -> e * 2)
                            .collect(Collectors.toList());
                    break;

                case "subtract":
                    list = list.stream()
                            .map(e -> e - 1)
                            .collect(Collectors.toList());
                    break;

                case "print":
                    list.
                            forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }
        }
    }
}
