package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        List<Car> cars = new LinkedList<>();
        while (n-- > 0) {
            String[] input = bf.readLine().split("\\s+");
            String model = input[0];
            double currentFuel = Double.parseDouble(input[1]);
            double fuelForKm = Double.parseDouble(input[2]);
            Car car = new Car(model, currentFuel, fuelForKm);
            cars.add(car);
        }
        String line = bf.readLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String modelOfCommand = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            for (Car currentCar : cars) {
                if (currentCar.getModel().equals(modelOfCommand)) {

                    if (currentCar.canMove(distance)) {
                        double fuelAmount = currentCar.getFuelAmount();
                        fuelAmount -= distance * currentCar.getFuelCostForKm();
                        currentCar.setFuelAmount(fuelAmount);
                        int oldDistance = currentCar.getDistance();
                        currentCar.setDistance(distance + oldDistance);

                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
            line = bf.readLine();
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
