import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> database = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!database.containsKey(continent)) {
                database.put(continent, new LinkedHashMap<>());
                LinkedHashMap<String, List<String>> countryAndCity = database.get(continent);
                countryAndCity.put(country, new ArrayList<>());
                countryAndCity.get(country).add(city);
            } else {
                LinkedHashMap<String, List<String>> countryAndCity = database.get(continent);
                if (!countryAndCity.containsKey(country)) {
                    countryAndCity.put(country, new ArrayList<>());
                }
                countryAndCity.get(country).add(city);
            }
        }

        database
                .entrySet()
                .forEach(c -> {
                    System.out.println(c.getKey() + ":");
                    LinkedHashMap<String, List<String>> countriesAndCities = c.getValue();
                    countriesAndCities
                            .forEach((k, v) -> System.out.printf("  %s -> %s%n", k, printList(v)));

                });
    }

    private static String printList(List<String> list) {
        return String.join(", ", list);
    }

}
