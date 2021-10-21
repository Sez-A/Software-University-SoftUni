import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Path.of("D:\\Advanced Programing With Java" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Exercises" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        for (String string : strings) {
            int sum = 0;
            for (int i = 0; i < string.length() ; i++) {
                sum += string.charAt(i);
            }
            System.out.println(sum);
        }

    }
}
