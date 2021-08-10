import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while (!input.equals("end")) {
            System.out.println(input + " = " + reverse(input));
            input = reader.readLine();
        }
    }

    private static String reverse(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        
        return sb.toString();
    }
}
