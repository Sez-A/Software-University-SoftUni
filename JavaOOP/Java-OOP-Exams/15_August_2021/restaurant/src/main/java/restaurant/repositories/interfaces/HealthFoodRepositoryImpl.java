package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class HealthFoodRepositoryImpl<T> implements HealthFoodRepository<HealthyFood> {
    private Map<String, HealthyFood> healthyFoods;

    public HealthFoodRepositoryImpl() {
        this.healthyFoods = new LinkedHashMap<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return healthyFoods.get(name);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return healthyFoods.values();
    }

    @Override
    public void add(HealthyFood entity) {
        healthyFoods.putIfAbsent(entity.getName(), entity);
        healthyFoods.put(entity.getName(), entity);
    }
}
