import java.util.*;

public class PlantDiscovery {

    public static class Plant {
        private int rarity;
        private List<Integer> ratings;

        public Plant() {
            ratings = new ArrayList<>();
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Integer> getRatings() {
            return ratings;
        }

        public void resetAllRatings() {
            this.ratings = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Plant> plants = new HashMap<>();
        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("<->");
            String plantName = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            if (plants.containsKey(plantName)) {
                Plant currentPlant = plants.get(plantName);
                currentPlant.setRarity(currentPlant.getRarity() + rarity);
            } else {
                Plant plant = new Plant();
                plant.setRarity(rarity);
                plants.put(plantName, plant);
            }
        }

        String command = scan.nextLine();
        while (!command.equals("Exhibition")) {

            command = command.replaceAll(":", " ");
            command = command.replaceAll(" - ", " ");

            String[] tokens = command.split("\\s+");

            String commandName = tokens[0];
            String plantName = "";
            int value = 0;


            try {
                switch (commandName) {
                    case "Rate":
                        plantName = tokens[1];
                        value = Integer.parseInt(tokens[2]);
                        Plant plant = plants.get(plantName);
                        plant.getRatings().add(value);
                        break;
                    case "Update":
                        plantName = tokens[1];
                        value = Integer.parseInt(tokens[2]);
                        Plant plant1 = plants.get(plantName);
                        plant1.setRarity(value);
                        break;
                    case "Reset":
                        plantName = tokens[1];
                        Plant plant2 = plants.get(plantName);
                        plant2.resetAllRatings();
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
            }catch (Exception e) {
                System.out.println("error");
            }
            command = scan.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plants
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    double compare = Integer.compare(p2.getValue().getRarity(), p1.getValue().getRarity());
                    if (compare == 0) {
                        List<Integer> p2Ratings = p2.getValue().getRatings();
                        List<Integer> p1Ratings = p1.getValue().getRatings();

                        int p2Rating = 0;
                        for (Integer rating : p2Ratings) {
                            p2Rating += rating;
                        }
                        double averageP2Ratings = 1. * p2Rating / (p2Ratings.size());

                        int p1Rating = 0;
                        for (Integer rating : p1Ratings) {
                            p1Rating += rating;
                        }
                        double averageP1Ratings = p1Rating / (p1Ratings.size() * 1.);

                        compare = Double.compare(averageP2Ratings, averageP1Ratings);
                    }
                    return (int) compare;
                })
                .forEach(p -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n"
                        , p.getKey(), p.getValue().getRarity(), p.getValue().getRatings().stream()
                                .mapToDouble(Double::valueOf).average().orElse(0)));
    }
}
