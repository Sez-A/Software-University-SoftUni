import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = (char) (text.charAt(i) + 3) ;
            result.append(letter);
        }
        System.out.println(result);
    }
}
