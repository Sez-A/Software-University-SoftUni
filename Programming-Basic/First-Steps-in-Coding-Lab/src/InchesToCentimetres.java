import java.util.Scanner;

public class InchesToCentimetres {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double inches = Double.parseDouble(scan.nextLine());
        double centimetres = inches * 2.54;
        System.out.println(centimetres);
    }
}
