import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstArr = scan.nextLine().split(" ");
        String[] secondArr = scan.nextLine().split(" ");
        for (String secEl : secondArr) {
            for (String firstEl : firstArr) {
                if(secEl.equals(firstEl)){
                    System.out.print(secEl + " ");
                }
            }
        }
    }
}
