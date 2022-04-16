package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private List<Decoration> decorations;
    private List<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations
                .stream()
                .mapToInt(Decoration::getComfort)
                .sum();

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        // TODO: 7.12.2021 г. Check here for >=
        if (this.capacity > this.fish.size()) {
            this.fish.add(fish);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(this.getClass().getSimpleName()).append("):").append(String.format("%n"));
        sb.append("Fish: ");
        if (fish.isEmpty()) {
            sb.append("none").append(String.format("%n"));
        } else {
            String join = fish.stream()
                    .map(Fish::getName)
                    .collect(Collectors.joining(" "));
            sb.append(join).append(String.format("%n"));
        }
        sb.append("Decorations: ").append(getDecorations().size())
                .append(String.format("%n"))
                .append("Comfort: ").append(this.calculateComfort());

        return sb.toString();
    }

    @Override
    public List<Fish> getFish() {
        return this.fish;
    }

    @Override
    public List<Decoration> getDecorations() {
        return this.decorations;
    }
}
