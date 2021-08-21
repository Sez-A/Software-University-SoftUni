import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NeedForSpeed {
    public static class Car {
        int mileage;
        int fuel;

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Car> cars = new TreeMap<>();
        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\|");
            String carMake = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);
            if (cars.containsKey(carMake)) {
                Car car = cars.get(carMake);
                car.setMileage(car.getMileage() + mileage);
                car.setFuel(car.getFuel() + fuel);
            } else {
                Car car = new Car();
                car.setMileage(mileage);
                car.setFuel(fuel);
                cars.put(carMake, car);
            }
        }

        String command;
        while (!(command = scan.nextLine()).equals("Stop")) {
            String[] tokens = command.split(" : ");
            String carMake = tokens[1];
            Car car = cars.get(carMake);
            switch (tokens[0]) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int neededFuel = Integer.parseInt(tokens[3]);
                    if (car.getFuel() >= neededFuel) {
                        car.setMileage(car.getMileage() + distance);
                        car.setFuel(car.getFuel() - neededFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                , carMake, distance, neededFuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }

                    if (car.getMileage() >= 100_000) {
                        System.out.printf("Time to sell the %s!%n", carMake);
                        cars.remove(carMake);
                    }
                    break;
                case "Refuel":
                    int fuelToRefuel = Integer.parseInt(tokens[2]);
                    int currentFuel = car.getFuel();
                    if (currentFuel + fuelToRefuel >= 75) {
                        fuelToRefuel = 75 - currentFuel;
                    }
                    car.setFuel(fuelToRefuel + currentFuel);
                    System.out.printf("%s refueled with %d liters%n", carMake, fuelToRefuel);
                    break;
                case "Revert":
                    int kilometres = Integer.parseInt(tokens[2]);
                    car.setMileage(car.getMileage() - kilometres);
                    if (car.getMileage() < 10_000) {
                        car.setMileage(10_000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carMake, kilometres);
                    }
                    break;
            }
        }

        cars
                .entrySet()
                .stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue().getMileage(), c1.getValue().getMileage()))
                .forEach(c -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                        , c.getKey(), c.getValue().getMileage(), c.getValue().getFuel()));
    }
}
