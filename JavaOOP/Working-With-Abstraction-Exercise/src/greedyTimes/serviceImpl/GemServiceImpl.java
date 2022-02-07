
package greedyTimes.serviceImpl;

import greedyTimes.Gem;
import greedyTimes.services.GemService;

import java.util.List;

public class GemServiceImpl implements GemService {
    private List<Gem> gems;

    public GemServiceImpl(List<Gem> gems) {
        this.gems = gems;
    }

    @Override
    public Gem findGemByName(String name) {
        for (Gem gem : this.gems) {
            if (name.equals(gem.getName()))
                return gem;
        }
        return null;
    }

    @Override
    public boolean containsGem(String name) {
        for (Gem gem : this.gems) {
            if (name.equals(gem.getName()))
                return true;
        }
        return false;
    }
}
