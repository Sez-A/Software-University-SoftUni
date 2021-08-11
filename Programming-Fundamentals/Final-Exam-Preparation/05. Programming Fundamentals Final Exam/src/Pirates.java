import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cityInfo = scan.nextLine();

        Map<String, Map<Integer, Integer>> cities = new TreeMap<>();
        while (!cityInfo.equals("Sail")) {
            String[] tokens = cityInfo.split("\\|\\|");
            String cityName = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            cities.putIfAbsent(cityName, new HashMap<>());
            Map<Integer, Integer> populationAndGold = cities.get(cityName);

            for (Map.Entry<Integer, Integer> entry : populationAndGold.entrySet()) {
                population += entry.getKey();
                gold += entry.getValue();
            }
            cities.remove(cityName);
            populationAndGold = new HashMap<>();
            populationAndGold.put(population, gold);
            cities.put(cityName, populationAndGold);
            cityInfo = scan.nextLine();
        }

        String event = scan.nextLine();
        while (!event.equals("End")) {
            String[] tokens = event.split("=>");
            String town = tokens[1];
            switch (tokens[0]) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n"
                            , town, gold, people);

                    int remainingPopulation = 0;
                    int remainingGold = 0;
                    Map<Integer, Integer> currentValues = cities.get(town);
                    for (Map.Entry<Integer, Integer> entry : currentValues.entrySet()) {
                        remainingPopulation = entry.getKey() - people;
                        remainingGold = entry.getValue() - gold;
                    }

                    cities.remove(town);
                    if (remainingPopulation == 0 || remainingGold == 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        break;
                    } else {
                        currentValues = new HashMap<>();
                        currentValues.put(remainingPopulation, remainingGold);
                        cities.put(town, currentValues);
                    }
                    break;
                case "Prosper":
                    int goldForAdd = Integer.parseInt(tokens[2]);
                    if (goldForAdd < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    } else {
                        Map<Integer, Integer> value = cities.get(town);
                        for (Map.Entry<Integer, Integer> entry : value.entrySet()) {
                            entry.setValue(entry.getValue() + goldForAdd);
                            System.out.printf("%d gold added to the city treasury. " +
                                    "%s now has %d gold.%n", goldForAdd, town, entry.getValue());
                        }
                    }
                    break;
            }
            event = scan.nextLine();
        }

        if (!cities.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
             cities
                    .entrySet()
                    .stream()
                    .sorted((c1, c2) -> {
                        int firstCityGold = 0;
                        int secondCityGold = 0;
                        Map<Integer, Integer> firstCityEntry = c1.getValue();
                        Map<Integer, Integer> secondCityEntry = c2.getValue();
                        for (Integer value : firstCityEntry.values()) {
                            firstCityGold = value;
                        }
                        for (Integer value : secondCityEntry.values()) {
                            secondCityGold = value;
                        }
                        return Integer.compare(secondCityGold, firstCityGold);
                    })
                     .forEach(e -> {
                         e.getValue().forEach((k,v) -> System.out.println(String.format
                                 ("%s -> Population: %d citizens, Gold: %d kg",e.getKey(),k,v)));
                     });



        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
