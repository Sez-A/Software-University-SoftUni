import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        while (!"end".equals(word)) {
            String reversed = reverse(word);
            System.out.println(word + " = " + reversed);
            word = scan.nextLine();
        }
    }

    public static String reverse(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        return result;
    }
}
