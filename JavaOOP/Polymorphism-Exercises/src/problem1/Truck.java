package problem1;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void drive(double distance) {
        double fuelCost = (super.getFuelConsumption() + 1.6) * distance;
        if (fuelCost <= super.getFuelQuantity()) {
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.printf("Truck travelled %s km%n"
                    , decimalFormat.format(distance));
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double fuelLiters) {
        super.setFuelQuantity(super.getFuelQuantity() + fuelLiters * 0.95);
    }
}
