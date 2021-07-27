import java.util.Scanner;

public class Repeat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += repeateWord(words[i]);
        }
        System.out.println(result);
    }

    public static String repeateWord(String word) {
        int times = word.length();
        String result = "";
        for (int i = 0; i < times; i++) {
            result += word;
        }
        return result;
    }
}

