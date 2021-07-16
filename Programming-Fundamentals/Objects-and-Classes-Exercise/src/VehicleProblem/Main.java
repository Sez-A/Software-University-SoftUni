package VehicleProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //{typeOfVehicle} {model} {color} {horsepower}
        String input = scan.nextLine();
        List<Vehicles> vehicles = new ArrayList<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            //{typeOfVehicle} {model} {color} {horsepower}
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);
            Vehicles vehicle;
            if ("car".equals(type)) {
                vehicle = new Vehicles("Car", model, color, horsepower);
                vehicles.add(vehicle);
            } else if ("truck".equals(type)) {
                vehicle = new Vehicles("Truck", model, color, horsepower);
                vehicles.add(vehicle);
            }
            input = scan.nextLine();
        }

        String model = scan.nextLine();
        while (!"Close the Catalogue".equals(model)) {
            for (Vehicles vehicle : vehicles) {
                if (vehicle.getModel().equals(model)) {
                    System.out.println(vehicle);
                    break;
                }
            }
            model = scan.nextLine();
        }

        double carHP = printAverageHorsepower(vehicles, "Car");
        System.out.println(String.format("Cars have average horsepower of: %.2f.",carHP));
        double truckHP = printAverageHorsepower(vehicles, "Truck");
        System.out.println(String.format("Trucks have average horsepower of: %.2f.",truckHP));
    }

    public static double printAverageHorsepower(List<Vehicles> vehicles, String type) {
        double sum = 0.0;
        int cnt = 0;
        for (Vehicles vehicle : vehicles) {
            if(vehicle.getType().equals(type)){
                sum += vehicle.getHorsepower();
                cnt++;
            }
        }
	if(sum == 0) {return 0;}
        return sum / cnt;
    }

}
