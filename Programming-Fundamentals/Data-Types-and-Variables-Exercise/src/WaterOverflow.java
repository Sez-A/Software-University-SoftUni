import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int capacity = 255;
        int tank = 0;
        for (int i = 0; i < n; i++) {
            int litters = Integer.parseInt(scan.nextLine());
            if (tank + litters > capacity) {
                System.out.println("Insufficient capacity!");
            } else {
                tank += litters;
            }
        }
        System.out.println(tank);
    }
}
