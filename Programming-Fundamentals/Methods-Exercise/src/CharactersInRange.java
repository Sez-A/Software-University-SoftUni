import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char startIndex = scan.nextLine().charAt(0);
        char endIndex = scan.nextLine().charAt(0);

        if (startIndex > endIndex) {
            printCharacters(endIndex, startIndex);
        }else{
            printCharacters(startIndex,endIndex);
        }

    }

    public static void printCharacters(char first, char end) {
        for (int i = first + 1; i < end; i++) {
            System.out.print(String.format("%c ", i));
        }

    }
}
