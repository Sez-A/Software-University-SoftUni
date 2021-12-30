package RawData;

import java.util.List;

public class Car {
    private String model;
    private int enginePower;
    private String cargoType;
    private List<Double> tires;

    public Car(String model, int enginePower, String cargoType, List<Double> tires) {
        this.model = model;
        this.enginePower = enginePower;
        this.cargoType = cargoType;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getCargoType() {
        return cargoType;
    }

    public List<Double> getTires() {
        return tires;
    }
}
