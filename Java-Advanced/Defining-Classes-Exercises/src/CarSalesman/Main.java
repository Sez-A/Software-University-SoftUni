package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine = null;
            switch (input.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    for (int j = 2; j < input.length; j++) {
                        char symbol = input[j].charAt(0);

                        if (Character.isDigit(symbol)) {
                            int displacement = Integer.parseInt(input[2]);
                            engine = new Engine(model, power, displacement);
                        } else {
                            String efficiency = input[2];
                            engine = new Engine(model, power, efficiency);
                        }

                    }
                    break;
                case 4:
                    engine = new Engine(model, power, Integer.parseInt(input[2]), input[3]);
                    break;
            }
            engines.add(engine);
        }

        int m = Integer.parseInt(bf.readLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = bf.readLine().split("\\s+");
            String carModel = input[0];
            String engineName = input[1];
            Engine engine = null;
            for (Engine currentEngine : engines) {
                if (currentEngine.getModel().equals(engineName)) {
                    engine = currentEngine;
                }
            }
            Car car = null;
            switch (input.length) {
                case 2:
                    car = new Car(carModel, engine);
                    break;
                case 3:
                    for (int j = 2; j < input.length; j++) {
                        char symbol = input[j].charAt(0);
                        if (Character.isDigit(symbol)) {
                            int weight = Integer.parseInt(input[2]);
                            car = new Car(carModel, engine, weight);
                        } else {
                            String color = input[2];
                            car = new Car(carModel, engine, color);
                        }
                    }
                    break;
                case 4:
                    int weight = Integer.parseInt(input[2]);
                    String color = input[3];
                    car = new Car(carModel, engine, weight, color);
                    break;
            }
            cars.add(car);
        }

        for (Car car : cars) {
     //       Engine currentEngine = car.getEngine();

            if(car.getWeight() == 0 && car.getEngine().getDisplacement() == 0 ) {
                System.out.println(String.format("%s:\n" +
                                "%s:\n" +
                                "Power: %d\n" +
                                "Displacement: n/a\n" +
                                "Efficiency: %s\n" +
                                "Weight: n/a\n" +
                                "Color: %s"
                        , car.getModel()
                        , car.getEngine().getModel()
                        , car.getEngine().getPower()
                        , car.getEngine().getEfficiency()
                        , car.getColor()));

            }else if(car.getEngine().getDisplacement() == 0) {
                System.out.println(String.format("%s:\n" +
                                "%s:\n" +
                                "Power: %d\n" +
                                "Displacement: n/a\n" +
                                "Efficiency: %s\n" +
                                "Weight: %d\n" +
                                "Color: %s"
                        , car.getModel()
                        , car.getEngine().getModel()
                        , car.getEngine().getPower()
                        , car.getEngine().getEfficiency()
                        ,car.getWeight()
                        , car.getColor()));
            } else if (car.getWeight() == 0) {
                System.out.println(String.format("%s:\n" +
                                "%s:\n" +
                                "Power: %d\n" +
                                "Displacement: %d\n" +
                                "Efficiency: %s\n" +
                                "Weight: n/a\n" +
                                "Color: %s"
                        , car.getModel()
                        , car.getEngine().getModel()
                        , car.getEngine().getPower()
                        ,car.getEngine().getDisplacement()
                        , car.getEngine().getEfficiency()
                        , car.getColor()));
            }else {
                System.out.println(String.format("%s:\n" +
                                "%s:\n" +
                                "Power: %d\n" +
                                "Displacement: %d\n" +
                                "Efficiency: %s\n" +
                                "Weight: %d\n" +
                                "Color: %s"
                        , car.getModel()
                        , car.getEngine().getModel()
                        , car.getEngine().getPower()
                        , car.getEngine().getDisplacement()
                        , car.getEngine().getEfficiency()
                        ,car.getWeight()
                        , car.getColor()));
            }
        }
    }
}