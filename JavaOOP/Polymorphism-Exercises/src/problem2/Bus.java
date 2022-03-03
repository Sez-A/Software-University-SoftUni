package problem2;

import problem1.Vehicle;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean condition) {
        isEmpty = condition;
    }

    @Override
    public void drive(double distance) {
        double fuelCost = 0;
        if (isEmpty) {
             fuelCost = super.getFuelConsumption() * distance;
            if (fuelCost <= super.getFuelQuantity()) {
                DecimalFormat decimalFormat = new DecimalFormat("###.##");
                System.out.printf("Bus travelled %s km%n"
                        , decimalFormat.format(distance));
                super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            }else {
                System.out.println("Bus needs refueling");
            }
        }else {
            fuelCost = (super.getFuelConsumption() + 1.4) * distance;
            if (fuelCost <= super.getFuelQuantity()) {
                DecimalFormat decimalFormat = new DecimalFormat("###.##");
                System.out.printf("Bus travelled %s km%n"
                        , decimalFormat.format(distance));
                super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            }else {
                System.out.println("Bus needs refueling");
            }
        }


    }

    @Override
    public void refuel(double fuelLiters) {
        if(super.getFuelQuantity() + fuelLiters > super.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        }
        else if (fuelLiters > 0) {
            super.setFuelQuantity(super.getFuelQuantity() + fuelLiters);
        } else
            System.out.println("Fuel must be a positive number");
    }
}