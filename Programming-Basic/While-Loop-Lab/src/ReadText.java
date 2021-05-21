import java.util.Scanner;

public class ReadText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = "";
        while (!(input = scan.nextLine()).equals("Stop")) {
            System.out.println(input);
        }
    }
}
