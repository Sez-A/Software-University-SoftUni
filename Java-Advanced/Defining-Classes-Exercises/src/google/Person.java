package google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(System.lineSeparator());

        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(String.format("%s %s %.2f%n",
                    this.company.getName(), this.company.getDepartment(), this.company.getSalary()));
        }

        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(String.format("%s %d%n", this.car.getModel(), this.car.getSpeed()));
        }

        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            sb.append(String.format("%s %s%n", pokemon.getName(), pokemon.getType()));
        }

        sb.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parents) {
            sb.append(String.format("%s %s%n", parent.getName(), parent.getBirthday()));
        }

        sb.append("Children:").append(System.lineSeparator());
        for (Children child : children) {
            sb.append(String.format("%s %s%n", child.getName(), child.getBirthday()));
        }


        return sb.toString().trim();
    }
}
