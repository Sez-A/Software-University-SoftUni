import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<word>[A-Za-z]{3,})(\\1)");
        Matcher matcher = pattern.matcher(text);

        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group("word");
            words.add(word);
        }

        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            for (int j = 0; j < words.size(); j++) {
                String wordToCompare = words.get(j);
                if (!currentWord.equals(wordToCompare)) {
                    wordToCompare = reverseString(wordToCompare);
                    if (wordToCompare.equals(currentWord)) {
                        wordToCompare = reverseString(wordToCompare);
                        String pair = String.format("%s <=> %s", currentWord, wordToCompare);
                        pairs.add(pair);
                    }
                }
            }
        }
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
