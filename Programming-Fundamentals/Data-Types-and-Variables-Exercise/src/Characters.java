import java.util.Scanner;

public class Characters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startChar = Integer.parseInt(scan.nextLine());
        int lastChar = Integer.parseInt(scan.nextLine());
        for (int i = startChar; i <= lastChar ; i++) {
            System.out.print(String.format("%c ",i));
        }
    }
}
