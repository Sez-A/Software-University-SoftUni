package VehicleProblem;

public class Vehicles {
    //{typeOfVehicle} {model} {color} {horsepower}
    String type;
    String model;
    String color;
    int horsepower;

    public Vehicles(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public String getType(){
        return this.type;
    }

    @Override
    public String toString() {
        String result = String.format("Type: %s%nModel: %s%nColor: %s%n" +
                "Horsepower: %d", this.type, this.model, this.color, this.horsepower);
        return result;
    }
}
