package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForKm;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistance() {
        return distance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getFuelCostForKm() {
        return fuelCostForKm;
    }

    public boolean canMove(int distance) {
        return fuelAmount >= distance * fuelCostForKm;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }

}
