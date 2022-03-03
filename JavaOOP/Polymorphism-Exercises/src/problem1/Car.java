package problem1;

import java.text.DecimalFormat;

public class Car extends Vehicle{
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }


    @Override
    public void drive(double distance) {
        double fuelCost = (super.getFuelConsumption() + 0.9) * distance ;
        if(fuelCost <= super.getFuelQuantity()) {
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.printf("Car travelled %s km%n"
                    ,decimalFormat.format(distance));
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
        }else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double fuelLiters) {
        super.setFuelQuantity(super.getFuelQuantity() + fuelLiters);
    }
}
