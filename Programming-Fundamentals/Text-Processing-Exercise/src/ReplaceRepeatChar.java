import java.util.Scanner;

public class ReplaceRepeatChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        char baseLetter = input.charAt(0);
        StringBuilder result = new StringBuilder();
        result.append(baseLetter);
        for (int i = 1; i < input.length() ; i++) {

            if(baseLetter != input.charAt(i)){
                baseLetter = input.charAt(i);
                result.append(baseLetter);
            }
        }
        System.out.println(result);
    }
}
