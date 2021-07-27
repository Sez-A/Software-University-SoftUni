import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String removeWord = scan.nextLine(); // ice
        String text = scan.nextLine(); // kicegiciceeb

        while (text.contains(removeWord)) {
            int removeWordIndex = text.indexOf(removeWord);
            int removeWordLength = removeWord.length();
            text = text.substring(0, removeWordIndex) + text.substring(removeWordIndex + removeWordLength);
        }

        System.out.println(text);
    }
}
