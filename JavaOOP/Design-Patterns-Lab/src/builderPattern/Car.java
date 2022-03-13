package builderPattern;

public class Car {
    private String make;
    private String color;
    private String numberOfDoors;
    private String horsePower;

    private Car() {
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public static CarBuilder build() {
        return new CarBuilder();
    }

    public static CarBuilder build(Car car) {
        CarBuilder builder = Car.build();
        builder.car.make = car.getMake();
        builder.car.color = car.getColor();
        builder.car.numberOfDoors = car.getNumberOfDoors();
        builder.car.horsePower = car.getHorsePower();
        return builder;
    }

    public static class CarBuilder {
        protected Car car = new Car();

        private CarBuilder() {

        }

        public Car buildCar() {
            return this.car;
        }

        public CarBuilder make(String make) {
            this.car.make = make;
            return this;
        }

        public CarBuilder color(String color) {
            this.car.color = color;
            return this;
        }

        public CarBuilder numberOfDoors(String numberOfDoors) {
            this.car.numberOfDoors = numberOfDoors;
            return this;
        }

        public CarBuilder horsePower(String horsePower) {
            this.car.horsePower = horsePower;
            return this;
        }
    }

    @Override
    public String toString() {
        return String.format("This is %s %s with %s doors and %s horse power!"
                , getColor(), getMake(), getNumberOfDoors(), getHorsePower());
    }
}
