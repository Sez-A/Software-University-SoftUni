import java.util.Scanner;

public class VowelsCount {

    public static int countOfVowels(String text) {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char latter = text.toLowerCase().charAt(i);
            switch (latter) {
                case 'a':
                case 'o':
                case 'e':
                case 'i':
                case 'u':
                    counter++;
                    break;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int count = countOfVowels(input);
        System.out.println(count);
    }
}
