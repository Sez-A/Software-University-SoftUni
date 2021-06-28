import java.util.Scanner;

public class RepeatString {

    public static String repeatString(String input, int reply){
        String result = "";
        for (int i = 0; i < reply ; i++) {
            System.out.printf("%s",input);
        }
        return result;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());
        String result = repeatString(input,n);
    }
}
