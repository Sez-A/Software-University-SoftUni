package singletonProb;

import java.util.HashMap;
import java.util.Map;

public class SingletonDataContainer implements SingletonContainer {
    private static SingletonDataContainer container;
    private Map<String, Integer> capitals;

    private SingletonDataContainer() {
        this.capitals = new HashMap<>();
        System.out.println("Initializing singleton object");
    }

    @Override
    public int getPopulation(Map<String, Integer> capitals, String name) {
        return capitals.get(name);
    }

    public static SingletonDataContainer getContainer() {
        if (container == null) {
           container = new SingletonDataContainer();
        }
        return container;
    }
}
