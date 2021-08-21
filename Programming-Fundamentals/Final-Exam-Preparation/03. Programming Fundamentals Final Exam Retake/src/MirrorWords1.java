import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<firstPart>[A-Za-z]{3,})(\\1)(\\1)(?<secondPart>[A-Za-z]{3,})(\\1)");
        Matcher matcher = pattern.matcher(text);


        List<String> firstWords = new ArrayList<>();
        List<String> secondWords = new ArrayList<>();
        int pairsCnt = 0;
        while (matcher.find()) {
            String firstWord = matcher.group("firstPart");
            String secondWord = matcher.group("secondPart");
            firstWords.add(firstWord);
            secondWords.add(secondWord);
            pairsCnt++;
        }

        if (pairsCnt == 0) {
            System.out.println("No word pairs found!");

        } else {
            System.out.printf("%d word pairs found!%n", pairsCnt);
        }


        List<String> mirrorWords = new ArrayList<>();
        for (int i = 0; i < firstWords.size(); i++) {
            String secondWord = secondWords.get(i);
            secondWord = reverseString(secondWord);
            if (firstWords.get(i).equals(secondWord)) {
                secondWord = reverseString(secondWord);
                String pair = String.format("%s <=> %s", firstWords.get(i), secondWord);
                mirrorWords.add(pair);
            }
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < mirrorWords.size(); i++) {
                if(i == mirrorWords.size() - 1) {
                    System.out.println(mirrorWords.get(i));
                }else {
                    System.out.print(mirrorWords.get(i) + ", ");
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
