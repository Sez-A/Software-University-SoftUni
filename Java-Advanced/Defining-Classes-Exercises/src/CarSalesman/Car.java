package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine;
    }

//    @Override
//    public String toString() {
//        return String.format("%s:\n" +
//                        "%s:\n" +
//                        "Power: %d\n" +
//                        "Displacement: %d\n" +
//                        "Efficiency: %s\n" +
//                        "Weight: %d\n" +
//                        "Color: %s\n"
//                , getModel()
//                , this.engine.toString(),
//                getWeight(), getColor());
//    }
}
