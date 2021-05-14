import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        double percent = Double.parseDouble(scan.nextLine()) * 0.01;

        double volume = length * width * height;

        double totalLitres = volume * 0.001;

        double realNeededLitres = totalLitres * (1 - percent);

        System.out.printf("%.2f%n",realNeededLitres);
    }
}
