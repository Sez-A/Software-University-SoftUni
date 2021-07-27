import java.util.Scanner;

public class Characters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (Character.isDigit(current)) {
                digits.append(current);
            } else if (Character.isLetter(current)) {
                letters.append(current);
            } else {
                symbols.append(current);
            }
        }

        System.out.println(digits);
        System.out.println(letters.toString());
        System.out.println(symbols);
    }
}
