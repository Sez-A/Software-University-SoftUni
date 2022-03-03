package problem1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");

        String[] truckInfo = scan.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]));

        Truck truck = new Truck(Double.parseDouble(truckInfo[1])
                ,Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commands = scan.nextLine().split("\\s+");
            switch (commands[0]) {
                case "Drive":
                    if(commands[1].equals("Car"))
                        car.drive(Double.parseDouble(commands[2]));
                    else
                        truck.drive(Double.parseDouble(commands[2]));
                    break;

                case "Refuel":
                        if(commands[1].equals("Car"))
                            car.refuel(Double.parseDouble(commands[2]));
                        else
                            truck.refuel(Double.parseDouble(commands[2]));
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
