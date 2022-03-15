package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.List;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private List<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        }

        if (aquarium == null) {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;

        if (type.equals("Plant")) {
            decoration = new Plant();
        } else if (type.equals("Ornament")) {
            decoration = new Ornament();
        }

        if (decoration == null) {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        Aquarium aquarium = getAquarium(aquariumName);


        aquarium.addDecoration(decoration);
        decorations.remove(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish = null;
        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        }

        if (fish == null) {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium = getAquarium(aquariumName);


        if (fishType.equals("FreshwaterFish") && aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")) {
            aquarium.addFish(fish);
        } else if (fishType.equals("SaltwaterFish") && aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")) {
            aquarium.addFish(fish);
        } else {
            return WATER_NOT_SUITABLE;
        }

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }


    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.getAquarium(aquariumName);
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.getAquarium(aquariumName);
        double fishPrices = aquarium
                .getFish()
                .stream()
                .mapToDouble(Fish::getPrice)
                .sum();

        double decorationPrices = aquarium
                .getDecorations()
                .stream()
                .mapToDouble(Decoration::getPrice)
                .sum();

        double total = fishPrices + decorationPrices;

        return String.format(VALUE_AQUARIUM, aquariumName, total);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        for (Aquarium aquarium : aquariums) {
            if (ind == aquariums.size() - 1) {
                sb.append(aquarium.getInfo());
            } else {
                sb.append(aquarium.getInfo())
                        .append(String.format("%n"));
            }
        }

        return sb.toString().trim();
    }

    private Aquarium getAquarium(String aquariumName) {
        return this.aquariums
                .stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
    }
}
