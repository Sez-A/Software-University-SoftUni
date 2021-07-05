import java.util.Scanner;

public class MiddleCharacter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        findTheCharacter(input);
    }

    public static void findTheCharacter(String text) {
        if(text.length() % 2 != 0  ){
            char letter = text.charAt(text.length() / 2);
            System.out.println(letter);
        }else{
            char letter1 = text.charAt(text.length() / 2 );
            char letter2 = text.charAt((text.length()/2) -1);
            System.out.println(String.format("%c%c",letter2,letter1));
        }
    }
}
// my way for solution of the problem