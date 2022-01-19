package february_2021.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }


    public void add(Car car) {
        if (capacity > data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        boolean isExist = false;
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                isExist = true;
                break;
            }

        }
        return isExist;
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        }
        List<Car> sortedCars = data.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getYear(), c1.getYear()))
                .collect(Collectors.toList());
        return sortedCars.get(0);
    }

    public Car getCar(String manufacturer, String model) {
        boolean isExist = false;
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:%n", this.name));
        for (Car car : data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
