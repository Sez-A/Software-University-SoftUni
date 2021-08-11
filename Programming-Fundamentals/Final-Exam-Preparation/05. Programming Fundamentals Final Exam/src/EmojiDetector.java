import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        long coolThreshold = 1;

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            coolThreshold *= Integer.parseInt(matcher.group());
        }

        int emojisCnt = 0;
        List<String> coolEmojis = new ArrayList<>();
        pattern = Pattern.compile("(?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))");
        matcher = pattern.matcher(text);

        while (matcher.find()) {
            int sum = 0;
            String currentEmoji = matcher.group("name");
            emojisCnt++;
            for (int i = 2; i < currentEmoji.length() - 2; i++) {
                sum += currentEmoji.charAt(i);
            }
            if (sum >= coolThreshold) {
                coolEmojis.add(currentEmoji);
            }
        }
        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojisCnt);
        if(!coolEmojis.isEmpty()) {
            for (String coolEmoji : coolEmojis) {
                System.out.println(coolEmoji);
            }
        }
    }
}
