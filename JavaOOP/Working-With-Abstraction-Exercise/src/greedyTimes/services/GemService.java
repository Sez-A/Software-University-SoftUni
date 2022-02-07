package greedyTimes.services;

import greedyTimes.Gem;

public interface GemService {

    Gem findGemByName(String name);

    boolean containsGem(String name);
}
