import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        String password = scan.nextLine();

        String passwordAsInput = "";
        while (!(passwordAsInput = scan.nextLine()).equals(password)) {

        }
        System.out.println("Welcome " + user + "!");
    }
}
