import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String thisKeg = "";
        double volumeNow = -1;
        for (int i = 0; i < n; i++) {
            String modelOfKeg = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            //π * r^2 * h
            double volume = Math.PI * radius * radius * height;
            if(volume > volumeNow){
                thisKeg = modelOfKeg;
                volumeNow = volume;
            }
        }
        System.out.println(thisKeg);
    }
}
