package pokemons;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String command = scan.nextLine();
        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");
            // "{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);


            if (trainers.containsKey(trainerName)) {
                Trainer t = trainers.get(trainerName);
                t.getPokemons().add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));

            } else {
                trainers.put(trainerName, new Trainer(trainerName));
                trainers.get(trainerName).getPokemons()
                        .add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
            }
            command = scan.nextLine();
        }

        while (!(command = scan.nextLine()).equals("End")) {
            for (Trainer trainer : trainers.values()) {
                if (trainer.getPokemons().size() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon : trainer.getPokemons()) {
                        if (pokemon.getElement().equals(command)) {
                            trainer.setBadges(trainer.getBadges() + 1);
                            havePokemon = true;
                            break;
                        }
                    }
                    if (!havePokemon) {
                        trainer.allPokemonsLooseHealth();
                    }
                }
            }
        }

        trainers
                .entrySet()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getBadges(), t1.getValue().getBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n",
                        t.getValue().getName(),
                        t.getValue().getBadges(),
                        t.getValue().getPokemons().size()));
    }
}
