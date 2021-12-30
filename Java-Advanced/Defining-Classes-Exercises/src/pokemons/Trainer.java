package pokemons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void allPokemonsLooseHealth() {
        for (int i = 0; i < this.pokemons.size(); i++) {
            Pokemon pokemon = this.pokemons.get(i);
            pokemon.setHealth(pokemon.getHealth() - 10);
        }

        this.pokemons = pokemons.stream().filter(p -> p.getHealth() > 0)
                .collect(Collectors.toList());
    }


}
