import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWord = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (int i = 0; i < bannedWord.length; i++) {
            String filterWord = wordFilter(bannedWord[i]);
           text = text.replace(bannedWord[i],filterWord);
        }
        System.out.println(text);
    }

    private static String wordFilter(String word) {
        int times = word.length();
        String result = "";
        for (int i = 0; i < times; i++) {
            result = result + "*";
        }
        return result;
    }
}
