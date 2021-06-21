import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] elements = scan.nextLine().split(" ");
        //String[] reverseElement = new String [elements.length];
        for (int i = 0; i < elements.length / 2; i++) {
            String temp = elements[i];
            elements[i] = elements[elements.length-1-i];
            elements[elements.length-1-i] = temp;
        }
        System.out.println(String.join(" ",elements));
    }
}
