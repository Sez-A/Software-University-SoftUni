package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new LinkedList<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {

            String line = bf.readLine();
            if (line.contains("fragile")) {

                List<Double> tires = new ArrayList<>();
                int index = line.indexOf("fragile");
                // todo info for tires
                String infoForTires = line.substring(index);
                String[] split = infoForTires.split("\\s+");

                String replace = line.replace(infoForTires, "");
                String[] tokens = replace.split("\\s+");

                String model = tokens[0];
                int enginePower = Integer.parseInt(tokens[2]);
                String carType = split[0];
                for (int j = 1; j < split.length; j++) {
                    String symbol = split[j];
                    //todo may has an exception
                    if (symbol.contains(".")) {
                        tires.add(Double.parseDouble(symbol));
                    }
                    // todo this may to be a solution
//                    else if (symbol.contains(",")) {
//                        tires.add(Double.parseDouble(symbol));
//                    }
                }

                Car car = new Car(model, enginePower, carType, tires);
                cars.add(car);


            } else if (line.contains("flamable")) {
                List<Double> tires = new ArrayList<>();
                int index = line.indexOf("flamable");
                // todo info for tires
                String infoForTires = line.substring(index);
                String[] split = infoForTires.split("\\s+");

                String replace = line.replace(infoForTires, "");
                String[] tokens = replace.split("\\s+");

                String model = tokens[0];
                int enginePower = Integer.parseInt(tokens[2]);
                String carType = split[0];
                for (int j = 1; j < split.length; j++) {
                    String symbol = split[j];
                    //todo may has an exception
                    if (symbol.contains(".")) {
                        tires.add(Double.parseDouble(symbol));
                    }
                    // todo this may to be a solution
//                    else if (symbol.contains(",")) {
//                        tires.add(Double.parseDouble(symbol));
//                    }
                }

                Car car = new Car(model, enginePower, carType, tires);
                cars.add(car);
            }
        }

        String line = bf.readLine();
        if(line.equals("fragile")) {
            for (Car car : cars) {
                if(line.equals(car.getCargoType())) {
                    List<Double> tires = car.getTires();
                    for (Double tirePressure : tires) {
                        if(tirePressure < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
            }
        }else if (line.equals("flamable")) {
            for (Car car : cars) {
                if(car.getCargoType().equals(line)) {
                    int enginePower = car.getEnginePower();
                    if(enginePower > 250) {
                        System.out.println(car.getModel());
                    }
                }
            }
        }
    }
}
