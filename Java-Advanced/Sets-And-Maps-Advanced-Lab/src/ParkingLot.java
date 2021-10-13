import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        Set<String> cars = new LinkedHashSet<>();
        while (!line.equals("END")) {
            String direction = line.substring(0, line.indexOf(", "));
            String plate = line.substring(line.indexOf(", ") + 2);
            if (direction.equals("IN")) {
                cars.add(plate);
            } else if (direction.equals("OUT")) {
                cars.remove(plate);
            }
            line = scan.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
