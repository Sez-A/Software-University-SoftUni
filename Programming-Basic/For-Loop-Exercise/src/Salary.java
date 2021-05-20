import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tabsCnt = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < tabsCnt; i++) {
            String website = scan.nextLine();
            if(website.equals("Facebook")) {
                salary -= 150;
            }else if (website.equals("Instagram")) {
                salary -= 100;
            }else if (website.equals("Reddit")) {
                salary -= 50;
            }
            if(salary <= 0) {
                System.out.println("You have lost your salary.");
                return;
            }
        }

        System.out.println(salary);
    }
}
